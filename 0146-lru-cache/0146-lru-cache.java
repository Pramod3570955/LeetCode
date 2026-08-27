import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {

        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move to MRU
        remove(node);
        insertAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Move to MRU
            remove(node);
            insertAfterHead(node);

        } else {

            // Create new node
            Node node = new Node(key, value);

            // Add to HashMap
            map.put(key, node);

            // Add to MRU
            insertAfterHead(node);

            // Remove LRU if capacity exceeded
            if (map.size() > capacity) {

                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}