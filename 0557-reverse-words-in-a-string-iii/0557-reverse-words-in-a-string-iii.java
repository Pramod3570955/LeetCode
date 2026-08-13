class Solution {
    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int start = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == ' ') {

                // Reverse current word
                reverse(arr, start, i - 1);

                // Start next word
                start = i + 1;
            }
        }

        // Reverse last word
        reverse(arr, start, arr.length - 1);

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}