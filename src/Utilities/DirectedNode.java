package Utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedNode {
	public int data;
	public List<DirectedNode> neighbors;
	public boolean visited = false;
	public DirectedNode(int data) {
		this.data = data;
		neighbors = new ArrayList<DirectedNode>();
	}
	
	public void addNeighbor(DirectedNode d) {
		if (this.neighbors.contains(d)) return;
		this.neighbors.add(d);
	}
	
	public String toString() {
		String s = this.data+"->\n";
		for (DirectedNode d : neighbors) {
			s = s+"   "+d.data+"\n";
		}
		return s;
	}
	
	public String toString(DirectedNode node) {
		String s = node.data+"->\n";
		for (DirectedNode d : node.neighbors) {
			s = s+"   "+d.data+"\n";
		}
		return s;
	}
	
	private String getTree(DirectedNode node, Set<DirectedNode> set) {
		String ans = toString(node);
		set.add(node);
		for ( DirectedNode d : node.neighbors) {
			if (set.add(d))
				ans += getTree(d, set);
			else continue;
		}
		return ans;
	}
	
	public String getTree() {
		return getTree(this,new HashSet<DirectedNode>());
	}
}
