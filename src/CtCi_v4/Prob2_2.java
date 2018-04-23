package CtCi_v4;

import Utilities.Node;

public class Prob2_2 {
	
	/*
	 * 2.2 Write code to find nth to the last node of a single linked list
	 * easy way is to first traverse it once and find the num of nodes and then traverse it once more to nth node
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2. Return 4.
	 */

	public static void main(String[] args) {
		Node n = Node.populateList(7);
		System.out.println(n);
//		System.out.println(findNthToLastNode(n, 4));
//		System.out.println(findNthToLastNodeBook(n, 7));
		System.out.println(deleteNthToLastNode(n, 0));
	}
	
	public static int findNthToLastNode(Node node, int n) {
		if (node == null) return -1;
		int size = 0;
		Node node1 = node;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		int ans = -1;
		for (int i = 0; i < size-n+2; i++) {
			ans = node1.data;
			node1 = node1.next;
		}
		return ans;
	}
	
	// Assumption : minimum n nodes
	public static int findNthToLastNodeBook(Node node, int n) {
		if (node == null || n < 1) return -1;
		Node runner = node;
		
		// Distance b/w runner and node is 'n'
		for (int i = 0; i < n-1; i++) {
			runner = runner.next;
		}
		
		while (runner.next != null) {
			runner = runner.next;
			node = node.next;
		}
		return node.data;
	}
	
	// Delete nth to last node from LinekdList (LeetCode)
	public static Node deleteNthToLastNode(Node node, int n) {
		if (node == null || n < 1) return node;
		Node dummy = node;
		Node runner = node; // fast runner
		Node walker = node; // slow runner
		
		// distance of n b/w runner and node
		for (int i = 0; i < n-1; i++) {
			if (runner == null)
				return null;
			runner = runner.next;
		}
		if (runner.next == null) {
			return node.next;
		}
		int test = 0;
		while (runner.next != null) {
			if (test != 0)
				walker = walker.next;
			node = node.next;
			runner = runner.next;
			test++;
		}
		// runner points to the end
		// node points at the node to be removed
		// walker points to the node before node
		
		walker.next = node.next;
		return dummy;
	}

}
