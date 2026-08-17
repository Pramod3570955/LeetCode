class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D
            int row = mid / cols;
            int col = mid % cols;

            // Get value

           if (matrix[row][col] == target) {

                return true;

            } else if (matrix[row][col] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
            // Compare with target


        }

        return false;
    }
}