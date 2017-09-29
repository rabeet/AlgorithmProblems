package LeetCode;

public class Prob110_BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.right)-(maxDepth(root.left))) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }
    
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
