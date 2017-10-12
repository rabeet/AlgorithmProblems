package MustDoQuestions.Trees;

import Utilities.TreeNode;

public class MaxPathSumInATree {

	public static void main(String[] args) {
		// Find max path sum in a tree, -ve nodes are possible
		TreeNode node = TreeNode.deSerializeTree(new Integer[]{1,2,3,4,5});
		System.out.println(maxPathSum(node));
		TreeNode node1 = TreeNode.deSerializeTree(new Integer[]{1,9,-21,2,-1,5});
		System.out.println(maxPathSum(node1));
	}
	
	/*
	 * 		1
	 *  2		3
	 * 4 5
	 */
	public static int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return root.val;
		return root.val+Math.max(maxPathSum(root.left), maxPathSum(root.right));
	}

}
