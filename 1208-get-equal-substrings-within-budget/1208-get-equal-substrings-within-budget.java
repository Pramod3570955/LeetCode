class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int left = 0;
        int cost = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // 1. Add current character's conversion cost
            int currentCost = Math.abs(
                s.charAt(right) - t.charAt(right)
            );
            cost += currentCost;

            // 2. Shrink while budget is exceeded
            while (cost > maxCost) {

                // Remove left character's cost
                
                cost -= Math.abs(
                    s.charAt(left) - t.charAt(left)
                );


                // Move left
                left++;
            }

            // 3. Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }
}