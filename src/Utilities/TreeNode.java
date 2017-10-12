package Utilities;


public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent; // for 4.5
	public TreeNode (int data) {
		this.data = data;
	}
	
	
	public static TreeNode deSerializeTree(Integer[] arr) {
		if (arr == null) return null;
		return popNode(arr, 0);
	}
	
	private static TreeNode popNode(Integer[] arr, int i) {
		if (i >= arr.length) return null;
		TreeNode node = arr[i] == null ? null : new TreeNode(arr[i]);
		if (node == null) {
			// shift everything to the right one
			for (int k = i; k < arr.length-1; k++) {
				Integer temp = arr[k];
				arr[k] = arr[k+1];
				arr[k+1] = temp;
			}
			return node;
		}
		node.left = popNode(arr, 2*i+1);
		node.right = popNode(arr, 2*i+2);
		return node;
	
	}
	
	public String toString() {
		return toString(this);
	}
	
	public String toString(TreeNode node) {
		if (node == null) return "";
		String ans = ""+node.data+"\n";
		boolean temp = false;
		if (node.left != null) {
			ans += node.left.data+" ";
			temp = true;
		}
		if (node.right != null) {
			ans += node.right.data+" ";
			temp = true;
		}
		ans +=(!temp)?"NO CHILDREN\n":"\n";
		ans += toString(node.left);
		ans += toString(node.right);
		return ans;
	}
}
