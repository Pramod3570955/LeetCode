class Solution {
    public int reverseDegree(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // 1. Find normal alphabet position
            int alphabetPosition = ch - 'a' + 1;

            // 2. Find reverse alphabet value
            int reverseValue = 27 - alphabetPosition;

            // 3. Add position × reverse value
            answer += reverseValue * (i + 1);
        }

        return answer;
    }
}