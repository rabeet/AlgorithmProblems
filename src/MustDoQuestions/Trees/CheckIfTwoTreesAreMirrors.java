package MustDoQuestions.Trees;

import Utilities.TreeNode;

public class CheckIfTwoTreesAreMirrors {

	public static void main(String[] args) {
		// Check if 2 trees are mirror images of each other
		TreeNode t1 = TreeNode.deSerializeTree(new Integer[]{1,2,3});
		TreeNode t2 = TreeNode.deSerializeTree(new Integer[]{1,3,2});
		System.out.println(isMirror(t1, t2));
	}
	
	/*
	 * left of tree 1 should be the right of tree 2
	 * 
	 * 		1				1
	 * 	2		3		3		2
	 */
	public static boolean isMirror(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) return true;
		if (tree1 == null || tree2 == null) return false;
//		if (tree1.left.val != tree2.right.val) return false;
//		if (tree1.right.val != tree2.left.val) return false;
		if (tree1.val != tree2.val) return false;
		return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
	}
}
