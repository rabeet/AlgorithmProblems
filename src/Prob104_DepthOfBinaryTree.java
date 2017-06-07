import java.util.LinkedList;
import java.util.Queue;

public class Prob104_DepthOfBinaryTree {
	
	public static int maxlevel = 0;

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(4);
		root.right.right.left.left = new TreeNode(4);
		
		/**
		 * 			1
		 * 		2		3
		 * 					4
		 */
		
		inOrderTrav(root, 0);
		System.out.println("Max depth: " + maxlevel);
		System.out.println("Max depth2: " + maxDepth2(root));
		
	}
	
	/**
	 * 
	 * 		2
	 *   2	    4
	 *6    2  7   4
	 *  1           9
	 * 
	 */
	
	// 6/7/2017 update
	public static int maxDepth2(TreeNode root) {
		if (root == null) return 0;
		
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		int level = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
			level++;
		}
		return level;
	}
	
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