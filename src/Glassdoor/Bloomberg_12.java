package Glassdoor;

//URL:https://www.glassdoor.com/Interview/Bloomberg-L-P-Software-Engineer-Interview-Questions-EI_IE3096.0,13_KO14,31_IP1.htm
//reverse a linked list and validate a BST. 

import Utilities.ListNode;
import Utilities.TreeNode;

public class Bloomberg_12 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1); node.right = new TreeNode(6);
		System.out.println(isValidBST(node));
		node.right.left = new TreeNode(4);
		System.out.println(isValidBST(node));

		ListNode l = ListNode.populateList(5);
		System.out.println(l);
		System.out.println(reverseLinkedList(l));
	}

	static public ListNode reverseLinkedList(ListNode l) {
		if (l == null) return l;
		ListNode temp = null;
		while (l != null) {
			ListNode next = l.next;
			l.next = temp;
			temp = l;
			if (next == null) return l;
			l = next;
		}
		return temp;
	}

	static public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	static private boolean isValidBST(TreeNode node, int hi, int lo) {
		if (node == null) return true;
		if (node.data > hi || node.data < lo) return false;
		return isValidBST(node.left,node.data, lo) && isValidBST(node.right, hi, node.data);
	}
}
