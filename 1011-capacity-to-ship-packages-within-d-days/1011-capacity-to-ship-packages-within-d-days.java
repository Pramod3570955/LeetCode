class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find search range
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int daysUsed = 1;
            int currentLoad = 0;

            // Simulate shipping
            for (int weight : weights) {

                // Can package fit?
                if (currentLoad + weight <= mid) {

                    // Add to current day
                    currentLoad += weight;

                } else {

                    // New day
                    daysUsed++;
                    currentLoad = weight;
                }
            }

            // Binary search decision
            if (daysUsed <= days) {

                // Try smaller capacity
                right = mid - 1;

            } else {

                // Need larger capacity
                left = mid + 1;

            }
        }

        return left;
    }
}