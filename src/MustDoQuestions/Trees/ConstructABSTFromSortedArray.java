package MustDoQuestions.Trees;

import Utilities.TreeNode;

public class ConstructABSTFromSortedArray {

	public static void main(String[] args) {
		
		// Construct a BST from a sorted array
		TreeNode tree = constructBST(new Integer[] {1,2,3,4,5});
		System.out.println(tree);
	}
	
	
	/*
	 * 1,2,3,4,5,6 
	 * mid element will be root
	 * recursively call from here
	 */
	public static TreeNode constructBST(Integer[] arr) {
		return constructBST(arr, 0, arr.length-1);
	}
	
	private static TreeNode constructBST(Integer[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = constructBST(arr, start, mid-1);
		node.right = constructBST(arr, mid+1, end);
		return node;
	}

}
