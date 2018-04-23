package CtCi_v4;

import Utilities.Node;

public class Prob2_3 {
	
	/*
	 * Given access to only this node. Delete this (middle) node.
	 * couldn't think this one!
	 */

	public static void main(String[] args) {
		Node n = Node.populateList(5);
		deleteNode(n);
		System.out.println(n);
	}
	
	public static void deleteNode(Node c) {
		if (c == null || c.next == null) return;
		c.data = c.next.data;
		c.next = c.next.next;
	}

}
