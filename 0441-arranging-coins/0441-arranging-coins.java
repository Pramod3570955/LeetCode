class Solution {
    public int arrangeCoins(int n) {
            long left = 0;
            long right = n;
            long ans = 0;

            while (left <= right) {

                long mid = left + (right - left) / 2;

                long coins = mid * (mid + 1) / 2;

                if (coins <= n) {
                    // mid rows are possible
                    ans = mid;
                    // search for a larger answer
                    left = mid + 1;
                } else {
                    // too many coins
                    right = mid - 1;
                    // search smaller
                }
            }  
        
        return (int) ans;
    }
}