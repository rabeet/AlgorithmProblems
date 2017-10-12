package LeetCode;

public class Prob108_ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] arr) {
		return constructBST(arr, 0, arr.length - 1);
	}

	private static TreeNode constructBST(int[] arr, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = constructBST(arr, start, mid - 1);
		node.right = constructBST(arr, mid + 1, end);
		return node;
	}

}
