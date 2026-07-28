class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = new int[temp.length()];

        for (int i = 1; i < temp.length(); i++) {
            int len = lps[i - 1];

            while (len > 0 && temp.charAt(i) != temp.charAt(len)) {
                len = lps[len - 1];
            }

            if (temp.charAt(i) == temp.charAt(len)) {
                len++;
            }

            lps[i] = len;
        }

        return rev.substring(0, s.length() - lps[temp.length() - 1]) + s;
    }
}