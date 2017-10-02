package LeetCode;

public class Prob230_KthSmallestElementInABST {
	// recursive dfs. Keep a variable and go to the end
	// and after each backtrack increase it by one and see if k has been
	// reached.
	// if it has then make the ans as the root val otherwise keep backtracking
	int s = 0, ans = 0;

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;
		kthSmall(root, k);
		return ans;
	}

	public void kthSmall(TreeNode root, int k) {
		if (root == null)
			return;
		if (s == k)
			return;
		kthSmall(root.left, k);
		s++;
		if (s == k) {
			ans = root.val;
			return;
		}
		kthSmall(root.right, k);
	}

}
