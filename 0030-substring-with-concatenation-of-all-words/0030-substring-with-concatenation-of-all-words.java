class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;

        HashMap<String, Integer> map = new HashMap<>();

        // Required frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            HashMap<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // Word not required
                if (!map.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                // Add word
                window.put(
                    word,
                    window.getOrDefault(word, 0) + 1
                );

                count++;

                // Too many copies of this word
                while (window.get(word) > map.get(word)) {

                    String leftWord =
                        s.substring(left, left + wordLen);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }

                // Valid concatenation
                if (count == totalWords) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}