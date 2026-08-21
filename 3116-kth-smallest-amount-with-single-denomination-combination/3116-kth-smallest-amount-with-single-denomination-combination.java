class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        long right = 1_000_000_000_000L;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (countAmounts(coins, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    long countAmounts(int[] coins, long x) {

        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    long current = coins[i];

                    lcm = lcm / gcd(lcm, current) * current;

                    bits++;
                }
            }

            if (bits % 2 == 1) {
                count += x / lcm;
            } else {
                count -= x / lcm;
            }
        }

        return count;
    }

    long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}