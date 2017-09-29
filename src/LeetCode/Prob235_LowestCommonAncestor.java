package LeetCode;

public class Prob235_LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val>= root.val && q.val <= root.val) || (p.val <= root.val && q.val >= root.val)) {
            return root;
        }
        return (p.val <= root.val && q.val <= root.val) ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

}
