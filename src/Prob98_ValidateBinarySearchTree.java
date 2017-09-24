
public class Prob98_ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max)
            return false;
        return (isValidBST(root.left, (long)min, (long)root.val) && isValidBST(root.right,(long)root.val,(long)max));
    }

}
