package MustDoQuestions.LinkedLists;

import Utilities.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(5);
		ListNode n2 = new ListNode(2);
		n2.next = new ListNode(4);
		n2.next.next = new ListNode(4);
		System.out.println(merge(n2, n1));
	}

	// Merge 2 sorted lists into a new list
	public static ListNode merge(ListNode n1, ListNode n2) {
		ListNode n = new ListNode(0);
		ListNode temp = n;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				n.next = new ListNode(n1.val);
				n1 = n1.next;
			} else {
				n.next = new ListNode(n2.val);
				n2 = n2.next;
			}
			n = n.next;
		}

		while (n1 != null) {
			n.next = new ListNode(n1.val);
			n1 = n1.next;
			n = n.next;
		}

		while (n2 != null) {
			n.next = new ListNode(n2.val);
			n2 = n2.next;
			n = n.next;
		}
		return temp.next;
	}

}
