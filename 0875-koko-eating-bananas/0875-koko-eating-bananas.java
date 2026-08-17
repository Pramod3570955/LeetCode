class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long totalHours = 0;

            // Calculate required hours
            for (int pile : piles) {
                totalHours += ((long) pile + mid - 1) / mid;
            }

            // Speed is enough
            if (totalHours <= h) {
                right = mid - 1;
            }
            // Speed is too slow
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}