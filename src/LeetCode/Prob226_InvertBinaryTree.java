package LeetCode;
import java.util.Arrays;

public class Prob226_InvertBinaryTree {
	
	public static void main (String args[]) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(7);
		node.right = new TreeNode(9);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(3);
		node.right.right = new TreeNode(8);
		
		Prob226_InvertBinaryTree prob = new Prob226_InvertBinaryTree();
		TreeNode nodei = prob.invertTreeRabeet(node);
		System.out.println(nodei.val);
		System.out.println(nodei.left.val);
		System.out.println(nodei.right.val);
	}
	
	public TreeNode invertTree(TreeNode t) {
		if (t == null)
			return null;
		TreeNode left = invertTree(t.left);
		TreeNode right = invertTree(t.right);
		t.left = right;
		t.right = left;
		return t;
	}
	
	public TreeNode invertTreeRabeet(TreeNode t) {
		if (t == null)
			return null;
		TreeNode temp = t.right;
		t.right = t.left;
		t.left = temp;
		invertTree(t.left);
		invertTree(t.right);
		return t;
	}
}