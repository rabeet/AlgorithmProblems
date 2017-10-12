package MustDoQuestions.Trees;

import Utilities.TreeNode;

public class LowestCommonAncestorOf2Nodes {

	public static void main(String[] args) {
		// Find the Lowest Common Ancestor of 2 nodes in a tree
		TreeNode node = TreeNode.deSerializeTree(new Integer[]{1,2,3,4,5,6});
		TreeNode n1 = node.right.right;
		TreeNode n2 = node.left.right;
		System.out.println(lowestCommonAncestor(node, n1, n2));
	}
	
	// Assuming that the input is always valid
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) return root;
		TreeNode left = lowestCommonAncestor(root.left, node1, node2);
		TreeNode right = lowestCommonAncestor(root.right, node1, node2);
		return left == null ? right // left is null? the answer must be in the right subtree
				: right != null ? root // left is not null and right is not null? the answer must be root 
						: left; // right is null so the answer is left
	}
}
