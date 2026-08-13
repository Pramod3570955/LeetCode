class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] countP = new int[26];
        int[] countWindow = new int[26];

        // Count p
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add right character
            countWindow[s.charAt(right) - 'a']++;

            // If window too large
            if (right - left + 1 > p.length()) {
                countWindow[s.charAt(left) - 'a']--;
                left++;
            }

            // Check anagram
            if (right - left + 1 == p.length()
                    && Arrays.equals(countP, countWindow)) {
                result.add(left);
            }
        }

        return result;
    }
}