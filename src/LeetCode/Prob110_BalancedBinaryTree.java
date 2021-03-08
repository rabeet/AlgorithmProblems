package LeetCode;

public class Prob110_BalancedBinaryTree {

    public static void main(String[] args) {
        var node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        System.out.println(isBalanced(node));
    }

	public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.right)-(maxDepth(root.left))) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }
    
    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
