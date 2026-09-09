class Solution {
    public long countCommas(long n) {

        long answer = 0;

        // Numbers with 1, 2, 3, ... commas
        for (int commas = 1; ; commas++) {

            long start = power10(3 * commas);

            if (start > n) {
                break;
            }

            long end = power10(3 * (commas + 1)) - 1;

            // Don't go beyond n
            end = Math.min(end, n);

            // Number of integers in this range
            long count = end - start + 1;

            // Every number in this range has 'commas' commas
            answer += count * commas;
        }

        return answer;
    }

    private long power10(int exponent) {
        long result = 1;

        for (int i = 0; i < exponent; i++) {
            result *= 10;
        }

        return result;
    }
}