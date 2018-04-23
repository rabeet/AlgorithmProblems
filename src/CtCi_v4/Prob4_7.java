package CtCi_v4;
import java.util.Random;

import Utilities.TreeNode;

public class Prob4_7 {

	/*
	 * 4.7. Given two very large b trees determine if small is a subtree of
	 * large.
	 * 
	 * Way 1: Deserialize large and small and see if small is a subarray of
	 * large. O(large + small) TC O(large) + O(small) SC
	 * 
	 * Way 2: Find every occorunce of small's root node on large and run the
	 * isSubTree on large again
	 * O(large*small) Time Complexity
	 * O(1) space complexity not counting stack calls
	 * 
	 */

	public static void main(String[] args) {
		Integer[] arr = new Integer[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		TreeNode large = TreeNode.deSerializeTree(arr);
		TreeNode small = large.right.left.left.right.left;
		System.out.println(small.data);
		System.out.println(isSubtree(large, small));
	}

	public static boolean isSubtree(TreeNode large, TreeNode small) {
		if (large == null)
			return false;
		if (small == null)
			return true;

		boolean issub = false;
		if (large.data == small.data)
			issub = same(large, small);
		return issub || isSubtree(large.left, small) || isSubtree(large.right, small);
	}

	public static boolean same(TreeNode large, TreeNode small) {
		if (large == null && small == null)
			return true;
		else if (large == null && small != null)
			return false;
		else if (large != null && small == null)
			return true;
		else {
			if (large.data == small.data)
				return true && same(large.left, small.left) && same(large.right, small.right);
			else
				return false;
		}
	}

}
