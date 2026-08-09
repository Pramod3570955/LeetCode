import java.util.*;

class Solution {

    int n;
    int[] suffix;
    int[][] dp;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int answer = 0;

        for (int x = 1; x <= 2 * M && i + x <= n; x++) {

            int newM = Math.max(M, x);

            int opponent = solve(i + x, newM);

            int current = suffix[i] - opponent;

            answer = Math.max(answer, current);
        }

        return dp[i][M] = answer;
    }
}