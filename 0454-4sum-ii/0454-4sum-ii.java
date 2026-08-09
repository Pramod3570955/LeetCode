class Solution {
    public int fourSumCount(int[] nums1, int[] nums2,
                            int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: nums1 + nums2
        for (int a : nums1) {
            for (int b : nums2) {

                int sum = a + b;

                // store frequency
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Step 2: nums3 + nums4
        for (int c : nums3) {
            for (int d : nums4) {

                int sum = c + d;

                int required = -sum;

                // check map
                if (map.containsKey(required)) {
                    count += map.get(required);
                }
                
            }
        }

        return count;
    }
}