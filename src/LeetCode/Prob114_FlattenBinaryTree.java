package LeetCode;

import java.util.Stack;

public class Prob114_FlattenBinaryTree {

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode ans = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			int len = stack.size();
			for (int i = 0; i < len; i++) {
				TreeNode temp = stack.pop();
				if (temp.right != null)
					stack.push(temp.right);
				if (temp.left != null)
					stack.push(temp.left);
				temp.left = null;
				if (!stack.isEmpty())
					temp.right = stack.peek();
				else
					temp.right = null;
			}
		}
		return;
	}

}
