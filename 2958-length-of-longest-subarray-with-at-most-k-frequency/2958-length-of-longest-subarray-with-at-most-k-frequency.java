class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // add nums[right]
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // if frequency becomes greater than k
            while (map.get(nums[right]) > k) {

                // remove nums[left]
                map.put(nums[left], map.get(nums[left]) - 1);

                left++;
            }

            // calculate window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}