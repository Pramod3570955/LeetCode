class Solution {
    public String reorganizeString(String s) {

        // 1. Frequency
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // 2. Max Heap
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(b[1], a[1])
            );

        // 3. Add characters to heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        // 4. Build answer
        while (!maxHeap.isEmpty()) {

            int[] current = maxHeap.poll();
            char ch = (char) ('a' + current[0]);

            result.append(ch);

            current[1]--;

            if (previous != null && previous[1] > 0) {
                maxHeap.offer(previous);
            }

            previous = current;
        }

        // 5. Check if impossible
        if (previous != null && previous[1] > 0) {
            return "";
        }


        return result.toString();
    }
}