class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                int previousIndex = map.get(nums[i]);

                // Check distance here
                if (i - previousIndex <= k) {
                   return true;
                }
            }

            // Update latest index here
            map.put(nums[i], i);
        }

        // No nearby duplicate found
        return false;
    }
}