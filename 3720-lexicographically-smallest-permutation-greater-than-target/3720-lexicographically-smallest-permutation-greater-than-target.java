class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // We will store how many characters are used
        // while matching target.
        int[] used = count.clone();

        // First check whether target can be formed.
        for (int i = 0; i < n; i++) {

            int c = target.charAt(i) - 'a';

            if (used[c] == 0) {
                break;
            }

            used[c]--;
        }

        // Try changing from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Restore count to represent characters
            // available from position i onward.
            int[] temp = count.clone();

            // Use target[0 ... i-1]
            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int c = target.charAt(j) - 'a';

                if (temp[c] == 0) {
                    possible = false;
                    break;
                }

                temp[c]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            // Find smallest character greater than target[i]
            for (int c = current + 1; c < 26; c++) {

                if (temp[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Prefix same as target
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }

                    // Make this position bigger
                    ans.append((char) ('a' + c));
                    temp[c]--;

                    // Smallest possible suffix
                    for (int x = 0; x < 26; x++) {
                        while (temp[x] > 0) {
                            ans.append((char) ('a' + x));
                            temp[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}