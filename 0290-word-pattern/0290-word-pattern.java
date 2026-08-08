class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            // Check c → word
            if (map1.containsKey(c) && !map1.get(c).equals(word)) {
                return false;
            }
            // Check word → c
            if (map2.containsKey(word) && map2.get(word) != c) {
                return false;
            }
            // Add both mappings
            map1.put(c, word);
            map2.put(word, c);
        }

        return true;
    }
}