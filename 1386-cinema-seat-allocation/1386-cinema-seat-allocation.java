class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store reserved seats using bitmask
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            map.put(
                row,
                map.getOrDefault(row, 0) | (1 << (col - 1))
            );
        }

        // Rows with no reservations can fit 2 families
        int answer = (n - map.size()) * 2;

        int left = 0b0000011110;    // seats 2-5
        int middle = 0b0001111000;  // seats 4-7
        int right = 0b0111100000;   // seats 6-9

        // Process rows having reservations
        for (int mask : map.values()) {

            // Two families: left + right
            if ((mask & left) == 0 &&
                (mask & right) == 0) {

                answer += 2;

            // One family: any block available
            } else if ((mask & left) == 0 ||
                       (mask & middle) == 0 ||
                       (mask & right) == 0) {

                answer += 1;
            }
        }

        return answer;
    }
}