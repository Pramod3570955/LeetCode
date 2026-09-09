class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;
        int target = k * threshold;

        // First window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= target) {
            count++;
        }

        // Sliding window
        for (int i = k; i < arr.length; i++) {

            sum += arr[i] - arr[i - k];

            // TODO: check current window
            if (sum >= target) {
                count++;
            }
        }

        return count;
    }
}