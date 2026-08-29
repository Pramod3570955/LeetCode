class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices according to nums values
        Arrays.sort(indices, (a, b) ->
            Integer.compare(nums[a], nums[b])
        );

        int[] answer = nums.clone();

        int start = 0;

        while (start < n) {

            int end = start;

            // Find the current group
            while (end + 1 < n &&
                   nums[indices[end + 1]] - nums[indices[end]] <= limit) {

                end++;
            }
            List<Integer> values = new ArrayList<>();
            List<Integer> positions = new ArrayList<>();
            
            for (int i = start; i <= end; i++) {

                int originalIndex = indices[i];

                positions.add(originalIndex);
                values.add(nums[originalIndex]);
            }

            Collections.sort(positions);

            for (int i = 0; i < values.size(); i++) {
                answer[positions.get(i)] = values.get(i);
            }
            start = end + 1;
        }

        return answer;
    }
}