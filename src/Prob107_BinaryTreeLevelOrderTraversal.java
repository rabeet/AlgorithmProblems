import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Prob107_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.left = new TreeNode(4);
		t.right.right = new TreeNode(5);
		List<List<Integer>> list = levelOrderBottom(t);
		for (List<Integer> l : list) {
			for (int i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	/*
	 * Prob 107 - Binary tree level order traversal - II: This is breadth first
	 * search / level order traversal
	 * 
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (root == null)
			return list;

		Queue<TreeNode> dq = new LinkedList<TreeNode>();
		dq.add(root);

		while (!dq.isEmpty()) {
			List<Integer> qlist = new ArrayList<>();

			int size = dq.size();
			// Add all neighbors of all the visited nodes
			for (int i = 0; i < size; i++) {
				TreeNode node = dq.poll();
				qlist.add(node.val);
				if (node.left != null)
					dq.add(node.left);
				if (node.right != null)
					dq.add(node.right);
			}
			list.add(0, qlist);
		}
		return list;
	}

	public static List<List<Integer>> levelOrderBottomRabeet(TreeNode root) {

		Queue<TreeNode> dq = new LinkedList<TreeNode>();
		dq.add(root);

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(root.val));

		while (!dq.isEmpty()) {
			TreeNode node = dq.poll();
			List<Integer> qlist = new ArrayList<>();
			if (node.left != null) {
				dq.add(node.left);
				qlist.add(node.left.val);
			}
			if (node.right != null) {
				dq.add(node.right);
				qlist.add(node.right.val);
			}
			if (!qlist.isEmpty())
				list.add(qlist);
		}
		Stack stck = new Stack();
		for (List l : list)
			stck.push(l);

		return list;

	}
}
