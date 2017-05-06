import java.util.Stack;

public class Prob102_DepthOfBinaryTree {
	
	public static int maxlevel = 0;

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		/**
		 * 			1
		 * 		2		3
		 * 					4
		 */
		
		inOrderTrav(root, 0);
		System.out.println("Max depth: " + maxlevel);
		
	}
	
	/**
	 * 
	 * 		2
	 *   2	    4
	 *6    2  7   4
	 *  1           9
	 * 
	 */
	
	public static void inOrderTrav(TreeNode root, int level) {
		if (root == null) {
			if (level > maxlevel) {
				maxlevel = level;
			}
			return;
		}
		
		inOrderTrav(root.left, ++level);
		level--;
		inOrderTrav(root.right, ++level);
	}

	public static int maxDepth(TreeNode root) {
		
		inOrderTrav(root, 0);
		return maxlevel;
		
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}