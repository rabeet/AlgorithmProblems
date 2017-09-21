import java.util.Stack;

public class Prob236_LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(4);
		System.out.println(lowest(node, node.right, node.right.right).val);
	}

	public static TreeNode lowest(TreeNode root, TreeNode p, TreeNode q) {

		// Iterative sol
		// Add nodes to the queue until both nodes found
		// once both nodes found we know what level the ancestor will be.

		if (root == null)
			return null;

		// lowest(root.left, p, q);
		// lowest(root.right, p ,q);
		// boolean fp = find(root, p);
		// boolean fq = find(root, q);
		// if (fp && fq) return root;
		// return null;

		Stack<TreeNode> st = new Stack<>();
		addToStack(root, st);
		TreeNode ans = null;
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			boolean fp = find(node, p);
			boolean fq = find(node, q);
			if (fp && fq) { 
				ans = node;
				break;			
			}
		}
		return ans;
//		Stack<TreeNode> q1 = new Stack<TreeNode>();
//		q1.push(root);
//		TreeNode ans = null;
//		while (root != null) {
//			for (int i = 0; i < q1.size(); i++) {
//				TreeNode node = q1.peek();
//				if (node.left != null)
//					q1.push(node.left);
//				if (node.right != null)
//					q1.push(node.right);
//				// do work on the node
//				boolean fp = find(node, p);
//				boolean fq = find(node, q);
//				if (fp && fq)
//					ans = node;
//			}
//		}
	}
	
	public static void addToStack(TreeNode root, Stack<TreeNode> stack) {
		if (root == null) return;
		stack.push(root);
		addToStack(root.left, stack);
		addToStack(root.right, stack);
	}

	// find min level
	// int min_level = Math.min(p_level, q_level);
	// q1 = new LinkedList<TreeNode>();
	// q1.offer(root);
	// TreeNode ans = root;
	// level = 0;
	//
	// while (level <= min_level) {
	// for (TreeNode node : q1) {
	// boolean fp = find(node, p);
	// boolean fq = find(node,q);
	// q1.poll();
	// if (fp && fq) ans = node;
	// }
	// level++;
	// }

	private static boolean find(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return find(root.left, p) || find(root.right, p);
	}

}
