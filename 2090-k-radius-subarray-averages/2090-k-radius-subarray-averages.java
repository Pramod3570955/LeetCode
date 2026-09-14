import java.util.*;
class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n];

        // 1. Fill answer with -1
        Arrays.fill(ans, -1);


        // 2. Calculate window size
        int windowSize = 2 * k + 1;

        // 3. If window is larger than array,
        if (windowSize > n) {
            return ans;
        }


        // 4. Calculate sum of first window
        long sum = 0;

        for (int i = 0; i < windowSize; i++) {
            // add nums[i]
            sum += nums[i];
        }

        // 5. First valid center
        int center = k;

        // 6. Calculate first average
        ans[center] = (int)(sum / windowSize);

        int left = 0;
        // 7. Slide the window
        for (int i = windowSize; i < n; i++) {

            // Remove left element
            sum -= nums[left];
            left++;


            // Add new right element
    
            sum += nums[i];
            
            // Move center
            center++;


            // Calculate average
            ans[center] = (int)(sum / windowSize);
        }

        return ans;
    }
}