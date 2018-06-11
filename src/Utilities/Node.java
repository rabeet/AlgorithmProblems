package Utilities;

import java.util.Random;

public class Node {
	public int data;
	public Node next;
	public Node prev;
	public Node(int n) {
		this.data = n;
	}
	
	public String toString() {
		String s = ""+this.data;
		Node n = this;
		while (n.next != null) {
			n = n.next;
			s += "->"+n.data;
		}
		return s;
	}
	
	public static Node populateList(int limit) {
		limit = 9;
		Random random = new Random();
		Node node = new Node((limit));
		Node ret = node;
		for (int i = 1; i < 3; i++) {
			node.next = new Node((limit));
			node = node.next;
		}
		return ret;
	}
}