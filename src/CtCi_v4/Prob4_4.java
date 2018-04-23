package CtCi_v4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Utilities.TreeNode;

public class Prob4_4 {

	/*
	 * 4.4: Given a BST. Create a linked list for EACH DEPTH.
	 * 
	 * Use iterative solution of BFS where for each level you create a
	 * new LL for the level. Return a list of lists
	 * 
	 */
	public static void main(String[] args) {
		Integer[] arr = {5,2,6,1,3};
		TreeNode node = TreeNode.deSerializeTree(arr);
		System.out.println(node+"\n");
		List<List<TreeNode>> list = bstLists(node);
		for (List<TreeNode> l : list) {
			for (TreeNode n : l) {
				System.out.print(n.data);
			}
			System.out.println();
		}
	}
	
	public static List<List<TreeNode>> bstLists(TreeNode node) {
		List<List<TreeNode>> mainList = new ArrayList<List<TreeNode>>();
		if (node == null) return mainList;
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			int len = q.size();
			List<TreeNode> list = new LinkedList<>();
			for (int i = 0; i < len; i++) {
				TreeNode t = q.poll();
				list.add(t);
				if (t.left != null) q.add(t.left);
				if (t.right != null) q.add(t.right);
			}
			mainList.add(list);
		}
		return mainList;
	}
	
}
