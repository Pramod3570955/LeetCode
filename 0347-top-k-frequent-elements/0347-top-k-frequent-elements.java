class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            // add frequency
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // Add numbers and maintain size k
        for (int num : map.keySet()) {
            // add to heap
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
            // if size > k, remove
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        // Get k elements

        return result;
    }
}