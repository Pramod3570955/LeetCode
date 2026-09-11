class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int satisfied = 0;
        int windowGain = 0;
        int maxGain = 0;
        int left = 0;

        // 1. Calculate guaranteed customers
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }


        // 2. First window
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                windowGain += customers[i];
            }
        }

        maxGain = windowGain;


        // 3. Slide window
        for (int right = minutes; right < customers.length; right++) {

            if (grumpy[left] == 1) {
                windowGain -= customers[left];
            }

            if (grumpy[right] == 1) {
                windowGain += customers[right];
            }
            // update maximum
            maxGain = Math.max(maxGain, windowGain);


            left++;
        }

        // 4. Final answer
        return satisfied + maxGain;
    }
}