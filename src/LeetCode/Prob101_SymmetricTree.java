package LeetCode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob101_SymmetricTree {
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(2);
		t.left.left = new TreeNode(4);
		t.right.right = new TreeNode(3);
		t.left.right = new TreeNode(3);
//		t.right.right.right = new TreeNode(4);
//		t.right.right.left = new TreeNode(4);
		System.out.println(isSymmetric(t));
		System.out.println(isSymmetricRecursive(t));
	}
	
	public static boolean isSymmetricRecursive(TreeNode root) {
		if (root == null) return true;
		return bfs(root.left, root.right);
	}
	
	public static boolean bfs(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;
		return bfs(left.left, right.right) && bfs(left.right, right.left);
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		LinkedList<TreeNode> q = new LinkedList();
		q.offer(root);
		TreeNode dummy = new TreeNode(-1);
		while(!q.isEmpty()) {
			int size = q.size();
			for (int j = 0, k = size-1; j < k; j++,k--) {
				if (q.get(j).val != q.get(k).val) return false;
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = q.removeFirst();
				if (node == dummy) continue;
				if (node.left != null) q.add(node.left);
				else q.add(dummy);
				if (node.right != null) q.add(node.right);
				else q.add(dummy);
			}
		}
		return true;
	}
}
