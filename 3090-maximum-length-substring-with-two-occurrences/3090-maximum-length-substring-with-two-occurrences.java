import java.util.HashMap;

class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0, maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if any character count exceeds 2
            while (freq.get(c) > 2) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Optional: local test harness
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumLengthSubstring("bcbbbcba")); // Output: 4
        System.out.println(sol.maximumLengthSubstring("aaaa"));     // Output: 2
    }
}
