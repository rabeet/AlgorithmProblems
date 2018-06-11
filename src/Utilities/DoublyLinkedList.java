package Utilities;

public class DoublyLinkedList {
    public Node first;
    public Node last;
    public int size;
    public void addNode(int data) {
        if (last == null) {
            first = new Node(data);
            last = first;
        } else {
            last.next = new Node(data);
            last.next.prev = last;
            last = last.next;
        }
        size++;
    }
}
