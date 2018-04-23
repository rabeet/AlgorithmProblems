package CtCi_v6;

import java.util.List;

import Utilities.DirectedNode;

public class Prob4_1_RouteBetweenNodes {
	
	
	// Given a directed graph, design algo to find out whethere is a route b/w 2 nodes

	
	/*
	 * Given the center node, which is the root of all other nodes??
	 * Given the root node?
	 * 
	 * DFS from one of the nodes to find if reach the other node...
	 * 	potentially have to visit all the nodes
	 * DFS from both nodes to see if we meetup..
	 * BFS from both nodes, to see if we meetup..
	 * true condition: if even one node is visited, break and false
	 * false condition: 
	 */
	public static void main(String[] args) {
		
	}
	
	public static boolean routeBetweenNodes(DirectedNode node1, DirectedNode node2) {
		if (node1 == null || node2 == null) return false;
		if (node1 == node2) return true;
		if (node1.neighbors == null || node1.neighbors.isEmpty()
		|| node2.neighbors == null || node2.neighbors.isEmpty())
			return false;
		return visit(node1.neighbors) || visit(node2.neighbors);
	}
	
	private static boolean visit(List<DirectedNode> neighbors) {
		if (neighbors == null || neighbors.isEmpty())
			return false;
		for (DirectedNode node : neighbors) {
			if (node.visited == true)
				return true;
			node.visited = true;
		}
		boolean ret = false;
		for (DirectedNode node : neighbors) {
			ret = ret || visit(node.neighbors);
		}
		return ret;
	}

}
