package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob115_PopulatingNextRightPointerII {

	// USE the next feature to our advantage of traversal for const space
	// complexity
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		while (root != null) {
			TreeLinkNode fast = new TreeLinkNode(0); // dummy fast node
			TreeLinkNode slow = fast; // dummy slow node
			while (root != null) {
				if (root.left != null) { fast.next = root.left; fast = fast.next; }
				if (root.right != null) { fast.next = root.right; fast = fast.next;}
				root = root.next;
			}
			root = slow.next;
		}
	}

	public void connectExtraSpace(TreeLinkNode root) {
		if (root == null)
			return;
		// Use a queue DS
		/*
		 * add root to q while q is not empty for q's size: pop a node from q
		 * make its next q.peek() or null
		 */

		/*
		 * TEST:
		 * 
		 * 
		 */

		Queue<TreeLinkNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeLinkNode node = q.poll();
				if (i == len - 1)
					node.next = null;
				else
					node.next = q.peek();
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
		}
	}

}

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
