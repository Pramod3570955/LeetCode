class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            // update sum
            sum += num;
            // calculate sum - k
            int required = sum - k;
            // check HashMap
            if (map.containsKey(required)) {
                count += map.get(required);
            }
            // update HashMap
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}