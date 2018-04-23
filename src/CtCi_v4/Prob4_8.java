package CtCi_v4;
import java.util.ArrayList;
import java.util.List;

import Utilities.TreeNode;

public class Prob4_8 {

	/*
	 * 4.8: Design an algo to print all paths which sum up to a value
	 * where in a bin tree every node has a value
	 * 
	 * Am I given a value or am i given a node?
	 * Supposing a value is given to us.
	 * 
	 * for eg: if we have:
	 * 		2
	 * 	   4  1
	 *    0  3  -1
	 * Given a  value of 6: return 2->4->0, 2->4, 2->1->3
	 * 
	 * One way to approach this is to add a member sumSoFar to every node to the parent node
	 * but its only going to count the start of the node..
	 * 
	 * nother way is to call a pathSum method from every node if its value is under the sum
	 * which builds a string and returns that string if a path exists otherwise returns null or empty
	 * Time complexity is O(nodes^2) SC: O(1) not counting the stack calls
	 * 
	 * Yet another way would be serialize the arr and treat it as an array problem.
	 * 
	 * 
	 * going to give the second one a go
	 */
	public static void main(String[] args) {
		Integer[] arr = {2,1,4,3,-1,0};
		TreeNode node = TreeNode.deSerializeTree(arr);
		List<String> list = findPaths(node, 4);
		for (String s : list) {
			System.out.println(s);
			
		}
	}
	
	public static List<String> findPaths(TreeNode root, int value) {
		List<String> list = new ArrayList<String>();
		findSum(root, value, list);
		return list;
	}
	
	private static void findSum(TreeNode node, int value, List<String> list) {
		if (node == null) return;
		if (node.data <= value) findSum(node, value, list, "");
		findSum(node.left, value, list);
		findSum(node.right, value, list);
	}
	
	private static void findSum(TreeNode node, int value, List<String> list, String string) {
		if (node == null) {
			return;
		}
		boolean touched = false;
		if (value - node.data == 0) {
			string += ""+node.data;
			list.add(string);
			touched = true;
		}
		else if (value - node.data < 0) return;
		string += touched?"->" : ""+node.data+"->";
		findSum(node.left, value-node.data, list, string);
		findSum(node.right, value-node.data, list, string);
	}
	
}
