package MustDoQuestions.LinkedLists;

import Utilities.ListNode;

public class ReverseASinglyLinkedList {

	public static void main(String[] args) {
		ListNode n = new ListNode(4);
		n.next = new ListNode(5);
		n.next.next = new ListNode(6);
		System.out.println(n);
		System.out.println(reverse(n));
	}
	
	public static ListNode reverse(ListNode n) {
		ListNode temp = null;
		while (n != null) {
			ListNode z = n.next;
			n.next = temp;
			temp = n;
			n = z;
		}
		return temp;
	}

}
