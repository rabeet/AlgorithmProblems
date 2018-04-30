package LeetCode;


import java.util.HashMap;
import java.util.Map;

public class Prob146_LRUCache {

/*
 put:
    if key exists in hm:
        delete it from ll and move it to the head
    else:
        delete tail from ll and hm
        add node to the head of ll and add k,v to hm

get:
    if key exists in hm:
        move the respective node to head if it doesnt already be in head and return node
    else:
        return -1



cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
*/


    public static void main(String[] args) {
        Prob146_LRUCache cache = new Prob146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));;       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    private Map<Integer, Node> map;
    private DoublyLinkedList ll;

    public Prob146_LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        ll = new DoublyLinkedList(capacity);

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ll.delete(map.get(key));
            ll.add(map.get(key));
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            ll.delete(n);
            ll.add(n);
        } else {
            if (ll.isFull()) {
                map.remove(ll.tail.key);
                map.put(key, new Node(key, value));
                ll.add(map.get(key));
            } else {
                map.put(key, new Node(key, value));
                ll.add(map.get(key));
            }
        }
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    private int capacity;
    private int track;

    public DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        track = 0;
    }

    public boolean isEmpty() {
        return track==0;
    }

    public boolean isFull() {
        return track==capacity;
    }

    public int size() {
        return track;
    }

    void add(Node node) {
        if (node == null) return;
        if (isEmpty()) {
            head = node;
            tail = node;
            track++;
        } else if (isFull()) {
            delete();
            add(node);
        } else {
            node.nextNode = head;
            node.prevNode = null;
            head.prevNode = node;
            head = node;
            track++;
        }
    }

    void delete() {
        if (isEmpty()) return;
        if (tail.prevNode != null) tail.prevNode.nextNode = null;
        tail = tail.prevNode;
        track--;
    }

    void delete(Node node) {
        if (isEmpty()) return;
        if (head == node) head = head.nextNode;
        if (tail == node) tail = tail.prevNode;
        if (node.prevNode != null) node.prevNode.nextNode = node.nextNode;
        if (node.nextNode != null) node.nextNode.prevNode = node.prevNode;
        track--;
    }
}

class Node {
    Node prevNode;
    Node nextNode;
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}