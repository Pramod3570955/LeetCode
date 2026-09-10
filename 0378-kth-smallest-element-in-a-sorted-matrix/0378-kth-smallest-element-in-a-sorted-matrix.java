class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0])
            );

        // Add first element of every row
        for (int row = 0; row < matrix.length; row++) {
            minHeap.offer(new int[]{
                matrix[row][0],
                row,
                0
            });
        }

        // Process k elements
        for (int i = 0; i < k; i++) {

            int[] current = minHeap.poll();

            int value = current[0];
            int row = current[1];
            int col = current[2];

            // Add next element from the same row
            if (col + 1 < matrix.length) {
                minHeap.offer(new int[]{
                    matrix[row][col + 1],
                    row,
                    col + 1
                });
            }

            // kth smallest element
            if (i == k - 1) {
                return value;
            }
        }

        return -1;
    }
}