class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode current = head;

        // Find last node and length
        while (current.next != null) {
            current = current.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make circular
        current.next = head;

        // Start from head
        current = head;

        // Find new tail
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // New head
        ListNode newHead = current.next;

        // Break circle
        current.next = null;

        return newHead;
    }
}