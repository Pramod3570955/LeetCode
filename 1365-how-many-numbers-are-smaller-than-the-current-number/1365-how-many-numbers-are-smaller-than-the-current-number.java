class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        // Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Convert frequency to prefix sum
        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];
        }

        int[] ans = new int[nums.length];

        // Find count of smaller numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = freq[nums[i] - 1];
            }
        }

        return ans;
    }
}