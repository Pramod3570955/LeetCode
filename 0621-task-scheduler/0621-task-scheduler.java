class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        // 1. Count frequencies
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // 2. Find maximum frequency
        int maxFreq = 0;

        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // 3. Count tasks with maximum frequency
        int maxCount = 0;

        for (int freq : count) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        // 4. Calculate answer
        int formula = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, formula);
    }
}