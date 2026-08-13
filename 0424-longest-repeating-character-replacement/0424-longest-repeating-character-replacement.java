class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';
                        count[index]++;

            // Update max frequency
            maxFreq = Math.max(maxFreq, count[index]);

            // Shrink if replacements > k
           while (right - left + 1 - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }
}