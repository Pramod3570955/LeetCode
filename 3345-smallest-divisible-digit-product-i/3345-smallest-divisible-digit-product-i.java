class Solution {

    public int smallestNumber(int n, int t) {

        int num = n;

        while (true) {

            if (isValid(num, t)) {
                return num;
            }

            num++;
        }
    }

    private boolean isValid(int num, int t) {

    int product = 1;

    while (num > 0) {

         int digit = num % 10;

         product *= digit;

         num /= 10;
    }

    return product % t == 0;
    }
}