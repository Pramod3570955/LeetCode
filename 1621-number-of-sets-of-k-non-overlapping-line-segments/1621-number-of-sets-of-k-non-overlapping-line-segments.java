class Solution {

    static final long MOD = 1000000007L;

    public int numberOfSets(int n, int k) {

        int total = n + k - 1;
        int choose = 2 * k;

        return (int) combination(total, choose);
    }

    private long combination(int n, int r) {

        // Make r smaller
        if (r > n - r) {
            r = n - r;
        }

        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= r; i++) {

            numerator = numerator * (n - r + i) % MOD;

            denominator = denominator * i % MOD;
        }

        // denominator^(-1) mod MOD
        long inverse = modPow(denominator, MOD - 2);

        return numerator * inverse % MOD;
    }

    private long modPow(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}