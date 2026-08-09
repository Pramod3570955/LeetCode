class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // 1. Add all numbers
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;

        // 2. Check every number
        for (int num : set) {

            // 3. Is this the START of a sequence?
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 0;

                // 4. Count consecutive numbers
                while (set.contains(current)) {
                    // increase length
                    length++;
                    // move current forward
                    current++;
                }

                // 5. Update max
                max = Math.max(max, length);
            }
        }

        return max;
    }
}