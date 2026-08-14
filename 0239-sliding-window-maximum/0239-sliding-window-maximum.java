class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        int index = 0;

        for (int right = 0; right < nums.length; right++) {

            // 1. Remove indices outside window
            if (!deque.isEmpty() &&
                deque.peekFirst() < right - k + 1) {

                deque.pollFirst();
            }

            // 2. Remove smaller values from back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {

                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(right);

            // 4. Window reaches size k
            if (right >= k - 1) {

                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}