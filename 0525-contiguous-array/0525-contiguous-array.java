class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0 → -1
            // 1 → +1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }


            // Has this sum appeared before?
            if (map.containsKey(sum)) {

                // Calculate length
                int len = i - map.get(sum);

                // Update maximum
                maxLen = Math.max(maxLen, len);

            } else {
                   
                // Store FIRST occurrence
                map.put(sum, i);

            }
        }

        return maxLen;
    }
}