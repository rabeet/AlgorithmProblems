package CtCi_v4;
import java.util.HashSet;
import java.util.Set;

import Utilities.Node;

public class Prob2_1 {
	
	/*
	 * Write code to remove dupes from an unsorted LinkedList. Also how would you do this if a temp buffer was not allowed?
	 * Doable without buffer using O(n^2): 2 nested loops
	 */

	public static void main(String[] args) {
		Node n = Node.populateList(10);
		System.out.println(n);
		removeDupesFromLinkedList(n);
		System.out.println(n);

	}
	
	public static void removeDupesFromLinkedList(Node n) {
		
		if (n.next == null) return;
		Node prev = null;
		// Use a map to keep track of duplicates
		Set<Integer> set = new HashSet<>();
		while (n != null) {
			boolean notExists = set.add(n.data);
			if (!notExists) {
				prev.next = n.next;
			} else {
				prev = n;
			}
			n = n.next;
		}
	}

}
