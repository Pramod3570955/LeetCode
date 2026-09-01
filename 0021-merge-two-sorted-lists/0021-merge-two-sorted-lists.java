class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; 
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                // attach list1
                current.next = list1; 
                // move list1
                list1 = list1.next;
            } else {
                // attach list2
                current.next = list2;
                // move list2
                list2 = list2.next;
            }

            // move current
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}