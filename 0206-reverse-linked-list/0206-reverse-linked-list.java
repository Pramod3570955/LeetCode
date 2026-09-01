class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {

            // 1. Save next node
            next = curr.next;
            
            // 2. Reverse current pointer
            curr.next = prev;
            // 3. Move prev
            prev = curr;

            // 4. Move curr
            curr = next;

        }

        // New head
        return prev;
    }
}