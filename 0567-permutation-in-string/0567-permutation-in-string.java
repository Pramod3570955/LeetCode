class Solution {
   public boolean checkInclusion(String s1, String s2) {


    if (s1.length() > s2.length()) {
        return false;
    }

    int[] count1 = new int[26];
    int[] count2 = new int[26];

    // Count characters in s1
    for (int i = 0; i < s1.length(); i++) {
        count1[s1.charAt(i) - 'a']++;
    }

    int windowSize = s1.length();
    int left = 0;

    // Sliding window
    for (int right = 0; right < s2.length(); right++) {

        // Add right character
        count2[s2.charAt(right) - 'a']++;

        // Window too large
        if (right - left + 1 > windowSize) {
            count2[s2.charAt(left) - 'a']--;
            left++;
        }

        // Check when window size is correct
        if (right - left + 1 == windowSize) {
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
    }

    return false;
  }
}
