import java.util.LinkedList;
import java.util.Queue;

public class Prob111_MinimumDepthOfBinaryTree {
	
	public static void main(String args[]) {
		
	}
	
	/*
	 * Prob 111 - Min depth binary tree:
		Do a breadth first search and stop whenever one of the neighbors of a node is null
		
		Algo:
		add root to queue
		int level = 1;
		while q is not empty:
			for each element in the queue at this time:
				pop it from the queue
				if both of its neighbours is null then return level
				else add all of its neighbors to the queue
			level++;
		return level;
		
		Testing:
				1
			2		3
		4	  3   6
		
		Expected: 3
		Level = 1
		Q: 2,3
		Level = 2;
		Q: 3,
		
		Output: 2
		
		Level = 1
		Q: 2 3
		Level = 2
		Q: 3 4 3
		Q: 4 3 6
		Level = 3
		Q: 3 6
		
		return 3!
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList();
		
		q.add(root);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left == null && node.right == null) return level;
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
			level++;
		}
		return level;
	}
}
