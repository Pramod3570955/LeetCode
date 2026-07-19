class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int i =1; i< nums.length; i++) {
            if(Math.abs(nums[i]) < Math.abs(ans)) {
                ans =nums[i];
            }
            else if(Math.abs(nums[i]) == Math.abs(ans) && nums[i] > 0) {
                ans = nums[i];
            }
        }
        return ans;
    }
}