class Solution {
    public int longestSubarray(int[] nums) {

        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // 1. Add nums[right]


            // 2. If there are more than 1 zero,
            //    shrink the window
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {

                // Remove nums[left]
                if (nums[left] == 0) {
                    zeroCount--;
                }


                // Move left
                left++;

            }

            // 3. Delete exactly one element
            //    and update maximum
            maxLen = Math.max(maxLen, right - left);


        }

        return maxLen;
    }
}