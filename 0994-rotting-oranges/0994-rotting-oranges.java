class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 3: Multi-source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process one minute
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Explore 4 directions
                for (int[] direction : directions) {

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 &&
                        newRow < rows &&
                        newCol >= 0 &&
                        newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        // Step 4: Check if fresh oranges remain
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}