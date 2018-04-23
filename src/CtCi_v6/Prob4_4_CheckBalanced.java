package CtCi_v6;

import Utilities.TreeNode;

public class Prob4_4_CheckBalanced {

	// Implement function to check if tree is balanced: heights of two subtrees of any node never differ by more than one
	
	public static void main(String[] args) {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.left.right = new TreeNode(4);
		System.out.println(isBalanced(TreeNode.deSerializeTree(new Integer[] {1,2,3,4,5,3,4,5,2})));
		System.out.println(isBalanced(n));
		n.left.right = null;
		System.out.println(isBalanced(n));
	}
	
	public static boolean isBalanced(TreeNode node) {
		if (node == null) return true;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		return (Math.abs(left-right) < 2) && isBalanced(node.left) && isBalanced(node.right);
	}

	private static int maxDepth(TreeNode node) {
		if (node == null) return 0;
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}

}
