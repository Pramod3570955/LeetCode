class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if palindrome is possible
        int oddCount = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // We only need half of each character
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int half = n / 2;

        char[] ans = new char[n];

        // Position we are currently trying to match
        int pos = 0;

        // Match target's left half
        while (pos < half) {

            int c = target.charAt(pos) - 'a';

            if (freq[c] == 0) {
                break;
            }

            ans[pos] = target.charAt(pos);
            freq[c]--;

            pos++;
        }

        // Case 1:
        // We matched the complete left half.
        if (pos == half) {

            // Put middle character
            if (n % 2 == 1) {
                ans[half] = (char) ('a' + middle);
            }

            // Mirror left half
            for (int i = 0; i < half; i++) {
                ans[n - 1 - i] = ans[i];
            }

            String candidate = new String(ans);

            // It may already be greater than target
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Backtrack
        while (true) {

            // Try to make current position bigger
            if (pos < half) {

                int start = target.charAt(pos) - 'a' + 1;

                for (int c = start; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[pos] = (char) ('a' + c);
                        freq[c]--;

                        // Fill remaining left half
                        int index = pos + 1;

                        for (int x = 0; x < 26; x++) {

                            while (freq[x] > 0) {
                                ans[index++] = (char) ('a' + x);
                                freq[x]--;
                            }
                        }

                        // Middle
                        if (n % 2 == 1) {
                            ans[half] = (char) ('a' + middle);
                        }

                        // Mirror
                        for (int i = 0; i < half; i++) {
                            ans[n - 1 - i] = ans[i];
                        }

                        return new String(ans);
                    }
                }
            }

            // Cannot make this position bigger.
            // Move one position backwards.
            if (pos == 0) {
                return "";
            }

            pos--;

            // Restore the character that matched target[pos]
            int c = target.charAt(pos) - 'a';
            freq[c]++;
        }
    }
}