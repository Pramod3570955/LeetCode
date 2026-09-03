class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        
        // Find the minimum element in the array
        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
        }
        
        // If the minimum element is odd, we can always make all elements odd
        if (minVal % 2 != 0) {
            return true;
        }
        
        // If the minimum element is even, all elements MUST be even
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}