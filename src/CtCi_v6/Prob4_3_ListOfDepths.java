package CtCi_v6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Utilities.TreeNode;

public class Prob4_3_ListOfDepths {
	
	// Given a bin tree create LinkedList of every depth
	
	/*
	 * BFS:
	 * 	at each depth
	 * 		initialize linkedlist
	 *  	add each item at that depth in the ll
	 *  	add ll to masterlist
	 */

	public static void main(String[] args) {
		
		TreeNode n = TreeNode.deSerializeTree(new Integer[] {1,2,3,4,5,6});
		TreeNode t = new TreeNode(1);
		t.right = new TreeNode(2);
		t.right.right = new TreeNode(3);
		buildList(n).stream().forEach(e -> {System.out.println();e.stream().forEach(m -> System.out.print(m.data + " -> "));});
		System.out.println();
		buildList(t).stream().forEach(e -> {System.out.println();e.stream().forEach(m -> System.out.print(m.data + " -> "));});
	}

	public static List<List<TreeNode>> buildList(TreeNode node) {
		List<List<TreeNode>> ans = new ArrayList<>();
		if (node == null) return ans;
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			List<TreeNode> ll = new LinkedList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				// visit items in q
				TreeNode t = q.poll();
				ll.add(t);
				// add its children to q
				if (t.left != null) q.offer(t.left);
				if (t.right != null) q.offer(t.right);
			}
			ans.add(ll);
			ll = new LinkedList<>();
		}
		return ans;
	}
}
