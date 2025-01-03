class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);

        if (node != null) {
            remove(node);
            prepend(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode();
        node.key = key;
        node.val = value;

        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        } else if (capacity <= map.size()) {
            remove(tail.prev);
        }

        prepend(node);
    }

    private void remove(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.prev = null;
        node.next = null;

        map.remove(node.key);
    }

    private void prepend(ListNode node) {
        ListNode oldNext = head.next;
        head.next = node;

        node.prev = head;
        node.next = oldNext;

        oldNext.prev = node;

        map.put(node.key, node);
    }

    class ListNode {
        ListNode next;
        ListNode prev;
        int val;
        int key;
    }
}
