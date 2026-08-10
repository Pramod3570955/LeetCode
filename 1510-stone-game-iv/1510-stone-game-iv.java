class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        dp[0] = false;

        for (int i = 1; i <= n; i++) {

            for (int square = 1; square * square <= i; square++) {

                int remaining = i - square * square;

                // YOUR CONDITION HERE
                if (!dp[remaining]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}