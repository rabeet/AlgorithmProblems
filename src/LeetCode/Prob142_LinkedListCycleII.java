package LeetCode;

import Utilities.ListNode;

public class Prob142_LinkedListCycleII {

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = node;
		System.out.println(detectCycle(node));
		boolean f = true;
		Object d = null;
		Object c = new Object();
		System.out.println(d == c);
	}

	/*
	 * 2 pointer approach: traverse one node at one speed at the other node at 2
	 * speed. once they meet. traverse one node from start and the other node at
	 * current position at same speed. where they meet, return that node.
	 */

	public static ListNode detectCycle(ListNode head) {

		if (head == null)
			return null;
		ListNode slow = head, fast = head, ans = null;
		int t = 0;
		boolean cont = false;

		while (slow != null && fast != null) {

			if (slow == fast && t != 0) {
				slow = head;
				cont = true;
			}
			t++;
			if (!cont)
				slow = slow.next;
			if (!cont) {
				fast = fast.next;
				if (fast != null)
					fast = fast.next;
			}

			if (cont) {
				while (true) {
					if (slow == fast)
						return slow;
					slow = slow.next;
					fast = fast.next;
					ans = slow;
				}
			}
		}
		return ans;
	}

}
