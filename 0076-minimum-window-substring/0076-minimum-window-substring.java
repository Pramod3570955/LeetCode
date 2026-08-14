class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Count characters in t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }


        int required = need.size();
        int formed = 0;

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).intValue() == need.get(c).intValue()) {
                    formed++;
                }
            }

            while (formed == required) {

                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }
 
                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {

                    window.put(leftChar, window.get(leftChar) - 1);

                    if (window.get(leftChar) < need.get(leftChar)) {
                        formed--;
                    }
                }

                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);

    }
}