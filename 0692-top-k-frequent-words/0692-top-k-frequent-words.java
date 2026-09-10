class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {

            if (!map.get(a).equals(map.get(b))) {
                return Integer.compare(map.get(a), map.get(b));
            }

            // Same frequency -> lexicographically larger comes first
            return b.compareTo(a);
        });

        // Keep only k best words
        for (String word : map.keySet()) {
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Extract in reverse order
        String[] result = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return Arrays.asList(result);
    }
}