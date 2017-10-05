package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob173_BSTIterator {

	class BSTIterator {

		// should ideally use a stack
		/*
		 * When initializing, add all the left elemnts to a stack.
		 * On every next() call:
		 * 	pop a node from the stack and see if it has right nodes.
		 * 		if it does then push all the left elements of this node on to the stack and return the node.
		 * 		otherwise return the node 
		 */
		List<Integer> list;
		int track;

		public BSTIterator(TreeNode root) {
			list = new ArrayList<Integer>();
			populateList(root);
			track = 0;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return track < list.size();
		}

		/** @return the next smallest number */
		public int next() {
			return list.get(track++);
		}

		private void populateList(TreeNode node) {
			if (node == null)
				return;
			populateList(node.left);
			list.add(node.val);
			populateList(node.right);
		}
	}

}
