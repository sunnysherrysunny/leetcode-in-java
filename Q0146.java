import java.util.HashMap;
import java.util.Map;

public class Q0146 {
}

class LRUCache {

    public LRUNode head;
    public LRUNode tail;
    public Map<Integer, LRUNode> map;
    public int capacity;
    public int size;

    public LRUCache(int capacity) {
        this.head = new LRUNode();
        this.head.prev = null;
        this.tail = new LRUNode();
        this.tail.next = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    private void setToHead(LRUNode n) {
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode n = map.get(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            setToHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode n = map.get(key);
            n.val = value;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            setToHead(n);
            map.put(key, n);
        } else {
            LRUNode n = new LRUNode();
            n.val = value;
            n.key = key;
            if (size == capacity) {
                // evict
                LRUNode last = tail.prev;
                last.prev.next = tail;
                tail.prev = last.prev;
                map.remove(last.key);
            } else {
                size++;
            }
            setToHead(n);
            map.put(key, n);
        }

    }
}


class LRUNode {
    public LRUNode prev;
    public LRUNode next;
    public int key;
    public int val;

    public LRUNode() {

    }

}