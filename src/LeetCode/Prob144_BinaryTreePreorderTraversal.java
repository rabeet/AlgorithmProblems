package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob144_BinaryTreePreorderTraversal {
	
	public static void main(String[] args) {
		System.out.println("abcvvv".replaceFirst("vv", ""));
		StringBuilder sb = new StringBuilder("Sdasd");
	}
	
	public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // Use a stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // Recursive:
    	// List<Integer> list = new ArrayList<>();
        // popList(root, list);
        // return list;
    	
    	// Iterative:
        return preorderTraversalIterative(root);
    }
    
    public void popList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        popList(root.left, list);
        popList(root.right, list);
    }
}
