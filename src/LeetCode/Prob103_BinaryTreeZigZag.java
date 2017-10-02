package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob103_BinaryTreeZigZag {

	public static void main(String[] args) {

	}

	// can do this using a queue O(n) TC and O(n)

	/*
	 * DS: ArrayList as a queue
	 * 
	 * while q is not empty: len = size of q int zig = 0; for i =0 to len if
	 * even print i to len else print len to i for i =0 to len pop an item add
	 * its children to q zig++;
	 */

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		List<TreeNode> q = new ArrayList<>();
		q.add(root);
		int zig = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			List<Integer> list = new ArrayList<>();
			if (zig % 2 == 0) {
				for (int i = 0; i < len; i++) {
					list.add(q.get(i).val);
				}
			} else {
				for (int i = len - 1; i >= 0; i--) {
					list.add(q.get(i).val);
				}
			}
			ans.add(list);
			zig++;
			for (int i = 0; i < len; i++) {
				TreeNode node = q.remove(0);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return ans;
	}
}
