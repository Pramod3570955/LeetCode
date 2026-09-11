class Solution {
    public int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {

            // Units digit must be even
            if (digits[i] % 2 != 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {

                // Don't reuse the same index
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < n; k++) {

                    // Don't reuse an index
                    // Hundreds digit cannot be 0
                    if (k == i || k == j || digits[k] == 0) {
                        continue;
                    }

                    // Create 3-digit number
                    int number = digits[k] * 100
                               + digits[j] * 10
                               + digits[i];

                    set.add(number);
                }
            }
        }

        return set.size();
    }
}