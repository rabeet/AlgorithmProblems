import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(9);
		t.right = new TreeNode(20);
		t.right.right = new TreeNode(7);
		t.right.left = new TreeNode(15);
		
		List<List<Integer>> list = levelOrder(t);
		for (List<Integer> l : list) {
			for (int i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	/*
	 * Prob 102 - Binary tree level order traversal:
This is a simple breadth first search

Algo:
	queue
	add node to queue
	list = list of list of ints
	while (queue !empty) {
		qlist = list of ints
		for each element in the queue currently:
			add it to the qlist
			add its children to the queue
		add qlist to list
	}
	 * 
	 */
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		
		while (!q.isEmpty()) {
			List<Integer> qlist = new ArrayList();
			int size = q.size();
			for (int i =0; i < size; i++) {
				TreeNode node = q.poll();
				qlist.add(node.val);
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
			list.add(qlist);
		}
		return list;
	}

}
