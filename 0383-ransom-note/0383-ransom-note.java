class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        // Count characters available in magazine
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            count[index]++;
        }

        // Use characters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';

            count[index]--;

            if (count[index] < 0) {
                return false;
            }
        }

        return true;
    }
}