package LeetCode;

import Utilities.ListNode;

public class Prob328_OddEvenLinkedList {

	public ListNode oddEvenList(ListNode n) {

		ListNode even = new ListNode(0);
		ListNode odd = new ListNode(0);
		ListNode te = even;
		ListNode to = odd;

		while (n != null && n.next != null) {
			odd.next = n;
			n = n.next;
			even.next = n;
			n = n.next;
			odd = odd.next;
			even = even.next;
		}
		even.next = null;
		if (n == null) {
			odd.next = te.next;
		} else {
			odd.next = n;
			odd = odd.next;
			odd.next = te.next;
		}
		return to.next;

	}

}
