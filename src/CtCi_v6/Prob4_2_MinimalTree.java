package CtCi_v6;

import Utilities.TreeNode;

public class Prob4_2_MinimalTree {
	
	// Given a sorted array with uniques, make bst with min height
	
	/*
	 * i = root node
	 * 2*i+1 = left node
	 * 2*i+2 = right node
	 * 
	 * 1,2,3,4,5,6
	 * 
	 * func TreeNode(arr, start, end):
	 * 	if (start > end) return null; 
	 * 	new node with value of mid of indices range
	 * 	node's left is func(arr, start, mid-1)
	 * 	node's right is func(arr, mid+1, end)
	 * 	return node
	 * 	
	 * 
	 * 		3
	 *   1		5
	 *     2  4   6
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(treeFromArray(new int[] {1,2,3,4,5,6}));

	}
	
	public static TreeNode treeFromArray(int[] arr) {
		if (arr == null || arr.length == 0) return null;
		return treeFromArray(arr, 0, arr.length-1);
	}

	private static TreeNode treeFromArray(int[] arr, int i, int j) {
		if (i > j) return null;
		int mid = (i+j)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = treeFromArray(arr, i, mid-1);
		node.right = treeFromArray(arr, mid+1, j);
		return node;
	}

}
