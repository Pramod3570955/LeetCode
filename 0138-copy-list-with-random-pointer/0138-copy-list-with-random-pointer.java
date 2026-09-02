class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Step 1: Create copied nodes and insert them after original nodes
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);

            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // Step 2: Connect random pointers
        current = head;

        while (current != null) {

            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step 3: Separate original and copied lists
        Node dummy = new Node(0);
        Node copyCurrent = dummy;

        current = head;

        while (current != null) {

            Node copy = current.next;

            current.next = copy.next;

            copyCurrent.next = copy;
            copyCurrent = copy;

            current = current.next;
        }

        return dummy.next;
    }
}