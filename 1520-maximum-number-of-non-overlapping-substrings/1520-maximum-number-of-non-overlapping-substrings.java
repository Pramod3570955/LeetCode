class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence
        for (int i = 0; i < s.length(); i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Generate valid intervals
        for (int i = 0; i < s.length(); i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] != i) {
                continue;
            }

            int[] interval = getInterval(s, i, first, last);

            if (interval != null) {
                intervals.add(interval);
            }
        }

        // Sort by ending position
        intervals.sort((a, b) ->
            Integer.compare(a[1], b[1])
        );

        List<String> answer = new ArrayList<>();

        int prevEnd = -1;

        // Greedy selection
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > prevEnd) {

                answer.add(
                    s.substring(left, right + 1)
                );

                prevEnd = right;
            }
        }

        return answer;
    }


    private int[] getInterval(
            String s,
            int start,
            int[] first,
            int[] last) {

        int left = start;

        int right = last[s.charAt(start) - 'a'];

        for (int i = left; i <= right; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] < left) {
                return null;
            }

            right = Math.max(right, last[c]);
        }

        return new int[]{left, right};
    }
}