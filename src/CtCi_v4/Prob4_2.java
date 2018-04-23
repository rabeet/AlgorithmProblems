package CtCi_v4;
import java.util.HashSet;
import java.util.Set;

import Utilities.DirectedNode;

public class Prob4_2 {

	
	/*
	 * Given a directed graph determine whether there is a path
	 * b/w 2 nodes:
	 * 
	 * Doesn't have to be shortest path
	 * Bruteforce way: 
	 * DO a DFS from every node and mark it as visited if it has been visited.
	 * See if the other node has been reached.
	 * 
	 * TS: O(neighbors^2) worst case
	 * SC: O(n) to mark them as visited + any calls on the stack FAACK!
	 * 
	 * some graph traversal algo (forgetting its name) method mb can be used here!
	 */
	
	public static void main(String[] args) {
		DirectedNode node = new DirectedNode(1);
		DirectedNode node1 = new DirectedNode(2);
		DirectedNode node2 = new DirectedNode(3);
		node.addNeighbor(node1);
		node1.addNeighbor(node2);
		node2.addNeighbor(node1);
		node2.addNeighbor(node);
		System.out.println(node.getTree());
		
		System.out.println(isPath(node, node2));
		System.out.println(isPath(node1, node));
		System.out.println(isPath(node2, node1));
	}
	
	public static boolean isPath(DirectedNode a, DirectedNode b) {
		return find(a,b,new HashSet<DirectedNode>());
	}
	
	private static boolean find(DirectedNode a, DirectedNode b, Set<DirectedNode> set) {
		boolean ans = false;
		for (DirectedNode a_i : a.neighbors) {
			if (a_i == b) return true;
			boolean added = set.add(a_i);
			if (added) return find(a_i, b, set);
		}
		
		return ans;
	}

}
