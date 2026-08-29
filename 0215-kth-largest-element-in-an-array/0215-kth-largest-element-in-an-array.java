class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            // Add number
            minHeap.offer(num);

            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Smallest among the k largest
        return minHeap.peek();
    }
}