package CtCi_v6;

import Utilities.TreeNode;

public class Prob4_6_Successor {

	// In a BST, find the next node in in-order traversal of a given node
	
	/*
	 * 
	 * if root has no children:
	 * 	if root has no parent:
	 * 		null
	 * 	if root is parents left:
	 * 		parent is the ans
	 * 	if root is parents right:
	 * 		go up to the parent whose left is valid and return that, if there is no such parent then return null
	 * if root's right is valid:
	 * 	left most of right subtree
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public static TreeNode nextNode(TreeNode root) {
		if (root == null) return null;
		if (root.right == null) {
			if (root.parent == null) return null;
			else if (isLeft(root))
				return root.parent;
			else
				return firstLeftAncestor(root);
		}
		return leftMost(root.right);
			
	}

	private static TreeNode leftMost(TreeNode node) {
		if (node.left != null)
			return leftMost(node.left);
		return node;
	}

	private static TreeNode firstLeftAncestor(TreeNode root) {
		if (root == null) return null;
		while (root != null) {
			if (isLeft(root))
				return root.parent;
			root = root.parent;
		}
		return root;
	}

	private static boolean isLeft(TreeNode root) {
		return root != null &&
				root.parent != null &&
				root.parent.left == root;
	}

}
