class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        // Find FIRST occurrence
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                first = mid;

                // Continue searching LEFT
                right = mid - 1;

            } else if (nums[mid] < target) {

                // Search RIGHT
                left = mid + 1;

            } else {

                // Search LEFT
                right = mid - 1;
            }
        }

        // Find LAST occurrence
        left = 0;
        right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                last = mid;

                // Continue searching RIGHT
                left = mid + 1;

            } else if (nums[mid] < target) {

                // Search RIGHT
                left = mid + 1;

            } else {

                // Search LEFT
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }
}