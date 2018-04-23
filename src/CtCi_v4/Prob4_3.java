package CtCi_v4;

import Utilities.TreeNode;

public class Prob4_3 {

	/*
	 * 4.3: Given a sorted array. create a binary tree!
	 * 
	 * [1,2,3,4,5] =
	 * 		 1
	 * 	  2     3
	 *  4   5
	 *  
	 * n = node, 2n+1 = left child, 2n+2 = right child
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		System.out.println(getTree(arr));
	}
	
	private static TreeNode popNode(int[] arr, int i) {
		if (i >= arr.length) return null;
		TreeNode node = new TreeNode(arr[i]);
		node.left = popNode(arr, 2*i+1);
		node.right = popNode(arr, 2*i+2);
		return node;
	}
	
	public static TreeNode getTree(int[] arr) {
		if (arr == null) return null;
		return popNode(arr, 0);
	}

}
