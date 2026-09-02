class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode pA = headA;
        ListNode pB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                pB = pB.next;
            }
        }

        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}