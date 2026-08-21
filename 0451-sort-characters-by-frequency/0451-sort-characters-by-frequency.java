class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            // count c
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> chars = new ArrayList<>(map.keySet());
        
        chars.sort((a, b) -> map.get(b) - map.get(a));
        
        StringBuilder result = new StringBuilder();
        
        for (char c : chars) {
            for (int i = 0; i < map.get(c); i++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}