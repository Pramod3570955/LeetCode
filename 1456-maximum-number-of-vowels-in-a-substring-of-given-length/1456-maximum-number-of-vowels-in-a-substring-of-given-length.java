class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                count++;
            }
        }

        int max = count;

        // Slide
        for (int i = k; i < s.length(); i++) {

            char add = s.charAt(i);
            char remove = s.charAt(i - k);

            if (isVowel(add)) {
                count++;
            }

            if (isVowel(remove)) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}