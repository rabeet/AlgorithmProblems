package CtCi_v4;

import Utilities.TreeNode;

public class Prob4_6 {

	/*
	 * 4.6: Find the first common ancestor of two nodes in a bin tree. Avoid
	 * using additional nodes in a DS. A node can be an ancestor of itself
	 * right? YES.
	 */
	private static TreeNode found = null;
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode node = TreeNode.deSerializeTree(arr);
		firstCommonAncestor(node, node.left, node.left.left);
		TreeNode n2 = firstCommonAncestor2(node, node.right.left, node.right.right);
		System.out.println(n2.data);
		System.out.println(found.data);
	}
	
	public static TreeNode firstCommonAncestor2(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || a == null || b == null) return null;
		if (find(root.left, a) && find(root.left,b))
			return firstCommonAncestor2(root.left, a, b);
		if (find(root.right, a) && find(root.right, b))
			return firstCommonAncestor2(root.right, a, b);
		else return root;
	}

	public static void firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) return;
		

		firstCommonAncestor(root.left, a, b);
		firstCommonAncestor(root.right, a, b);
		if (found != null) return;
		boolean fa = find(root,a), fb = find(root,b);
		if (fa && fb) found = root;
	}

	private static boolean find(TreeNode root, TreeNode a) {
		if (root == null) return false;
		return (root == a)? true: find(root.left, a) || find(root.right, a);
	}

}
