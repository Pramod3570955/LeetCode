class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // Add nums1
        for (int num : nums1) {
            set.add(num);
        }

        // Find intersection
        for (int num : nums2) {

            if (set.contains(num)) {
                result.add(num);
            }

        }
        // Convert result to array
        int[] ans = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i] = num;
            i++;
        }

        return ans;
    }
}