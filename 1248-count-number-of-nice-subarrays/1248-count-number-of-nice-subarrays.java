class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // 1. If nums[i] is odd, increase sum
            if (nums[i] % 2 != 0) {
                sum++;
            }
            

            // 2. Calculate required prefix
            int required = sum - k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }


            // 3. Add frequency of required prefix
            map.put(sum,map.getOrDefault(sum, 0) + 1);


            // 4. Store current prefix sum
            

        }

        return count;
    }
}