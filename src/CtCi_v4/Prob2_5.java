package CtCi_v4;

import Utilities.Node;

public class Prob2_5 {

	/*
	 * Find the starting of a loop in a corrupted linked list
	 */
	public static void main(String[] args) {
		Node n = new Node(0);
		Node nl = new Node(1);
		n.next = nl;
		nl.next = new Node(2);
		nl.next.next = new Node(3);
		nl.next.next.next = nl;
		
		System.out.println(findStartOfLoop(n).data);
	}
	
	public static Node findStartOfLoop(Node node) {
		// 2 pointer approach
		// After first meeting take slow pointer to head and make them both run at 
		// same speed until they meet which is the loop start
		// this code however does not check against non loop...
		
		Node n1= node, n2 = node;
		boolean first = true;
		while (true) {
			if (!first && n1 == n2)
				break;
			n1 = n1.next;
			n2 = n2.next.next;
			first = false;
		}
		
		// now they have met
		n1 = node;
		while (true) {
			if (n1 == n2) break;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n1;
	}
	
}
