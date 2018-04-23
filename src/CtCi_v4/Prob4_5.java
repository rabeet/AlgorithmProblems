package CtCi_v4;
import java.util.Stack;

import Utilities.TreeNode;

public class Prob4_5 {

	/*
	 * 4.5: Find the inorder successor of a node in a BST if every node has 
	 * a link to its parent
	 * inorder: left, self, right
	 * 
	 * if node.right is valid then node.right is the answer right?
	 * 
	 * 		5
	 * 	2		8
	 * 1  3   6
	 *     4
	 * 
	 * Inorder of the above is: 1,2,3,4,5,6,8
	 * Given: 5; return 6
	 * Given: 4; return 5
	 * Given: 8; return NUKLL
	 * 
	 * keep going to the parent until parent is null.
	 * That is your root. Do a simple inorder traversal from then until u
	 * get to the node u are looking for. the next node is the answer
	 * 
	 * A better solution is to: 
	 * find the parent of node
	 * node = parent
	 * do inorder from the node
	 * if node's prev is given_node then node is the ans.
	 * else node = parent.parent
	 * recurse
	 */
	
	public static void main(String[] args) {
		Integer[] arr = {5,2,8,1};
		TreeNode node = TreeNode.deSerializeTree(arr);
		System.out.println(node);
		System.out.println("Successor: " + inOrderSuccessor(node.right));
	}
	
	
	/* ALGO:
		 * is given null or node null?
		 * 	return null;
		 * is right valid?
		 * 	return min node of the right 
		 * else:
		 * 	go to the parent and:
		 * 		if node was the left child then parent is ans
		 * 		else node was the right child so call inorder of parent
	 *	 	5
	 * 	2		8
	 * 1  3   6
	 *     4 
	 */
	public static TreeNode inOrderSuccessor(TreeNode node) {
		if (node == null) return null;
		TreeNode p;
		if (node.parent == null || node.right != null) {
			p = leftMostChild(node.right);
		} else {
			while ((p = node.parent) != null ) {
				if (p.left == node)
					break;
				node = p;
			}
		}
		return p;
	}
	
//	public TreeNode inOrder(TreeNode node, TreeNode given, TreeNode right) {
//	if (node == null ||  given == null) return null;
//	if (given.right != null && given.right != right) {
//		return minNode(node.right);
//	}
//	else if (node.parent != null) {
//		if (node.parent.left == given) return parent;
//		else if (given.data > root.data && node.right == null)
//			return null;
//		else
//			return inOrder(node.parent, given, node);
//	} else {
//		if (root == given) return inOrder(node.right, given, null);
//		else return node;
//	}
//}
	
	private static TreeNode leftMostChild(TreeNode right) {
		if (right == null) return null;
		while (right.left != null) right = right.left;
		return right;
	}
	
}