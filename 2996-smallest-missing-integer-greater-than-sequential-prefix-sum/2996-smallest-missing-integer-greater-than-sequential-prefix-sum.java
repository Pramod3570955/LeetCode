import java.util.HashSet;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Find the longest sequential prefix
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: Store all numbers in a set for quick lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Find the smallest missing integer >= prefixSum
        int x = prefixSum;
        while (set.contains(x)) {
            x++;
        }

        return x;
    }
}
