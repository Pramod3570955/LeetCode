class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {

                    // Search LEFT
                    right = mid - 1;

                } else {

                    // Search RIGHT
                    left = mid + 1;

                }

            } 
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[right]) {

                    // Search RIGHT
                    left = mid + 1;

                } else {

                    // Search LEFT
                    right = mid - 1;

                }
            }
        }

        return -1;
    }
}