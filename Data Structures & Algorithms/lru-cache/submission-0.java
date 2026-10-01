class LRUCache {

    private static class Node {
        int key;
        int val;
        Node previous;
        Node next;


        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.previous = head;
        
    }



    private void add(Node node) {
        Node previous = this.tail.previous;
        previous.next = node;
        node.previous = previous;
        node.next = this.tail;
        this.tail.previous = node;

    }


    private void remove(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        // if we didn't find anything
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Get the node and update it
            Node node = map.get(key);
            node.val = value;
            // we just used it so we need to remove it and re-add it 
            remove(node);
            add(node);
            return;
        }
        // if we didn't already have the node
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        // Don't forget the main purpose of this problem, it's a LRU cache. so evict LRU
        // Check if we're above our capacity 
        if (map.size() > capacity) {
            // Evict
            Node lru = this.head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
