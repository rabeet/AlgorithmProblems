package CtCi_v4;

import Utilities.TreeNode;

public class Prob4_1 {

	
	/**
	 * What is a balanced tree:
	 * 		2
	 * 	3		 4
	 * 7  2    1   5
	 *      8        0
	 * 
	 * above tree is balanced because 0 and 8 are on the same level
	 * 
	 * 		2
	 * 	3		 4
	 *         5
	 *           0
	 *           
	 * above tree is not balanced because treenode 3 is 1 away from root while
	 * treenode 0 is 3 away from root 3-1 = 2 !< 1
	 */
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.right = new TreeNode(2);
		System.out.println(maxDepth(node));
		System.out.println(minDepth(node));
		System.out.println(isBalanced(node));
	}
	
	static public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return (maxDepth(root)-minDepth(root)) <= 1;
	}
	
	static public int maxDepth(TreeNode node) {
		if (node == null) return 0;
		int ans = 1+Math.max(maxDepth(node.left), maxDepth(node.right));
		return ans;
	}
	
	static public int minDepth(TreeNode node) {
		if (node == null) return 0;
		return 1+Math.min(minDepth(node.left) , minDepth(node.right));
	}

}
