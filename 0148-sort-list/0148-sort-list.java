class Solution {
    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split
        ListNode second = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        // Merge
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        current.next = (left != null) ? left : right;

        return dummy.next;
    }
}