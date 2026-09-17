import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000000;

        int[] best = new int[n];

        Arrays.fill(best, INF);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int answer = INF;

        for (int i = 0; i < n; i++) {

            // 1. Update prefix sum
            prefix += arr[i];

            // 2. Carry the best answer from previous index
            if (i > 0) {
                best[i] = best[i - 1];
            }

            // 3. Find a subarray whose sum is target
            int previousPrefix = prefix - target;

            if (map.containsKey(previousPrefix)) {

                int j = map.get(previousPrefix);

                // Current subarray = j + 1 ... i
                int currentLength = i - j;

                // 4. Combine with a previous non-overlapping subarray
                if (j >= 0 && best[j] != INF) {

                    answer = Math.min(
                        answer,
                        best[j] + currentLength
                    );
                }

                // 5. Update shortest target subarray
                best[i] = Math.min(
                    best[i],
                    currentLength
                );
            }

            // 6. Store prefix sum and index
            map.put(prefix, i);
        }

        return answer == INF ? -1 : answer;
    }
}