package CtCi_v6;

import Utilities.TreeNode;

public class Prob4_5_ValidateBST {
	
	// Implement function to check if a bt is a bst!
	
	/*
	 * 
	 * TODO: build min and max at each depth traversal of the tree
	 * func(node):
	 * 	true if null
	 * 	left.val <= node.val && right.val >= node.val && func(node.left) && func(node.right)
	 * 
	 * 
	 * 		5
	 * 	3		9
	 * 	  4			18
	 */
	
	public static void main(String[] args) {
		TreeNode test = TreeNode.deSerializeTree(new Integer[] {5,3,9,null,4,18});
		TreeNode test1 = TreeNode.deSerializeTree(new Integer[] {5,3,9,null,4});
		System.out.println(validateBST(test));
		System.out.println(validateBST(test1));
	}
	
	public static boolean validateBST(TreeNode node) {
		if (node == null) return true;
		return
				maxVal(node.left) <= node.val &&
				minVal(node.right) >= node.val &&
				validateBST(node.left) &&
				validateBST(node.right);
	}

	private static int minVal(TreeNode node) {
		return node == null ? Integer.MAX_VALUE : 
			Math.min(node.val, Math.min(minVal(node.left), minVal(node.right)));
	}

	private static int maxVal(TreeNode node) {
		return node == null ? Integer.MIN_VALUE : 
			Math.max(node.val, Math.max(maxVal(node.left), maxVal(node.right)));
	}

}
