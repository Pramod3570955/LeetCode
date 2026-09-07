class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1_000_000_007;

        long[] dp = new long[s.length() + 1];
        long[] last = new long[26];

        dp[0] = 1; // empty subsequence

        for (int i = 1; i <= s.length(); i++) {

            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1] - last[c] + MOD) % MOD;    // calculate new dp

            last[c] = dp[i - 1];   // update last[c]
        }

        return (int)(dp[s.length()] - 1 + MOD) % MOD;
    }
}