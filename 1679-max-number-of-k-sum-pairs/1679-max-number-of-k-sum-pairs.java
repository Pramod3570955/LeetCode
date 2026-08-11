class Solution {
    public int maxOperations(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {

            int complement = k - num;

            if (map.containsKey(complement)) {
                operations++;

                map.put(complement, map.get(complement) - 1);

                if (map.get(complement) == 0) {
                    map.remove(complement);
                }

            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }
}