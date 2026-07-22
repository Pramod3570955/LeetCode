/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
public
    ListNode swapPairs(ListNode head) {
        ListNode n1=new ListNode(0);       
        ListNode n2 = n1;
        n2.next = head;
        while(n2.next!=null && n2.next.next!=null){
            ListNode f1 = n2.next;
            ListNode s2 = f1.next;
            f1.next = s2.next;
            s2.next = f1;
            n2.next = s2;
            n2 = f1;

        }
        return n1.next;
        
    }

}