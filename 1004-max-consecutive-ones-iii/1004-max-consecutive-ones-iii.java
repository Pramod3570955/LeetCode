class Solution {
    public int longestOnes(int[] nums, int k) {
       int L= 0, zeros = 0, maxLen = 0;
       for(int R = 0; R < nums.length; R++) {
        if (nums[R] == 0) zeros++;
           while (zeros > k) {
              if(nums[L] == 0) zeros--;
              L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
}