package MustDoQuestions.Trees;

import Utilities.TreeNode;

public class CheckIfTreeIsBalanced {

	public static void main(String[] args) {
		
		// PART 1: check if tree is balanced:
		// maxdepth and mindepth should not differ by more than 1
		TreeNode n = TreeNode.deSerializeTree(new Integer[]{1,2,3,4,5});
		System.out.println(n);
		System.out.println(isBalancedTree(n));
		
		// PART 2: check if tree is height balanced:
		// a binary tree in which the depth of the two subtrees of every node never differ by more than 1
		/*
		 * preorder traversal:
		 * at each node -> check if the depth of both subtrees dont differ by 1 and call isbalanced tree on them
		 */
		System.out.println(isHeightBalancedTree(n));
	}
	
	public static boolean isBalancedTree(TreeNode t) {
		return maxDepth(t) - minDepth(t) < 2;
	}
	
	public static boolean isHeightBalancedTree(TreeNode t) {
		if (t == null) return true;
		int left = maxDepth(t.left), right = maxDepth(t.right);
		return Math.abs(left-right) < 2 && isHeightBalancedTree(t.left) && isHeightBalancedTree(t.right);
	}
	
	private static int maxDepth(TreeNode t) {
		if (t == null) return 0;
		return 1+Math.max(maxDepth(t.left), maxDepth(t.right));
	}
	
	private static int minDepth(TreeNode t) {
		if (t == null) return 0;
		return 1+Math.min(minDepth(t.left), minDepth(t.right));
	}

}
