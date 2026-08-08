class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            // 1. If n already exists → cycle → false
            if (set.contains(n)) {
               return false;
            }
            // 2. Add n to set
            set.add(n);
            // 3. Calculate sum of squared digits
            int sum = 0;

            while (n > 0) {
               int digit = n % 10;
               sum += digit * digit;
               n /= 10;
            }    
            // 4. Put sum into n
            n = sum;
        }

        return true;
    }
}