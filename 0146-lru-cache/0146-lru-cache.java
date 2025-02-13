class LRUCache {
    // node class for doubly ll
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value= value;
        }
    }
    private Map<Integer,Node> cache;
    private int capacity;
    private Node head;
    private Node tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // initialize dummy node head and tail
        this.head =new Node(0,0);
        this.tail = new Node(0,0);
        head.next=tail;
        tail.prev=head; 
        
    }
    private void addNode(Node node){
        //always add node right after head
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next= next;
        next.prev = prev;
    }
    private void moveToFront(Node node){
        removeNode(node);
        addNode(node);
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
         // Move to front as it was recently accessed
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
          Node node = cache.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToFront(node);
        } else {
            // Add new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            
            // Check capacity
            if (cache.size() > capacity) {
                // Remove least recently used item (last item before tail)
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */