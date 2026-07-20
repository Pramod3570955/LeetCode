class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int L=0, R=n-1, p=n-1;
        while(L<=R){
            int lSq = nums[L] * nums[L];
            int rSq = nums[R] * nums[R];
            if(lSq > rSq){
                ans[p--] = lSq;
                L++;
            } else {
                ans[p--] = rSq;
                R--;
            }
        }
        return ans;

    }
}