class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // 1. Update prefix sum
            sum += nums[i];

            // 2. Calculate required prefix sum
            int required = sum - goal;
            

            // 3. Check HashMap and update count
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}