class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        // 1. boundary / water check
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        // 2. mark visited
        grid[row][col] = 0;

        // 3. current cell contributes 1
        int area = 1;

        // 4. explore four directions
        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };
        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            area += dfs(grid, newRow, newCol);
        }

        // 5. return total area
        return area;
    }
}