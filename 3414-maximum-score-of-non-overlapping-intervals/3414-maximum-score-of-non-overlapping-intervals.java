import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by starting position
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[3], y[3]);
        });

        // next[i] = first interval whose start > a[i].right
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (a[mid][0] > a[i][1]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            next[i] = lo;
        }

        /*
         * dp[i][k]
         * = best answer considering intervals i...n-1
         *   and choosing at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        // Choosing 0 intervals
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0L, new int[0]);
        }

        // No intervals left
        for (int k = 1; k <= 4; k++) {
            dp[n][k] = new State(0L, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Don't take interval i
                State skip = dp[i + 1][k];

                // Take interval i
                State nextState = dp[next[i]][k - 1];

                int[] takeIndices =
                        addSorted(nextState.indices, a[i][3]);

                State take = new State(
                        (long) a[i][2] + nextState.score,
                        takeIndices
                );

                dp[i][k] = better(take, skip);
            }
        }

        return dp[0][4].indices;
    }

    /*
     * Add an original index while keeping the array sorted.
     */
    private int[] addSorted(int[] arr, int value) {

        int[] result = new int[arr.length + 1];

        int pos = 0;

        while (pos < arr.length && arr[pos] < value) {
            result[pos] = arr[pos];
            pos++;
        }

        result[pos] = value;

        while (pos < arr.length) {
            result[pos + 1] = arr[pos];
            pos++;
        }

        return result;
    }

    /*
     * Choose:
     * 1. Higher total weight
     * 2. If same weight, lexicographically smaller indices
     */
    private State better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        if (compareLexicographically(a.indices, b.indices) <= 0) {
            return a;
        }

        return b;
    }

    private int compareLexicographically(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }

    static class State {

        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}