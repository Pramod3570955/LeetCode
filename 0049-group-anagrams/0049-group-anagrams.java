class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();

            // Sort chars
            Arrays.sort(chars);
            // Create key
            String key = new String(chars);

            // Create list if key doesn't exist
            if (!map.containsKey(key)) {
               map.put(key, new ArrayList<>());
            }

            // Add str to list
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}