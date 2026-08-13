class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right]
            sum += nums[right];

            // Shrink while sum >= target
            while (sum >= target) {

                // Update minimum length

                minLen = Math.min(minLen, right - left + 1);
                // Remove nums[left]
                 sum -= nums[left];

                // Move left
                left++;

            }
        }

        // No valid subarray?
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}