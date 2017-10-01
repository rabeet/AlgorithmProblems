package LeetCode;

import java.util.Stack;

public class Prob206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		// Recursive: Working but slow!

		// if (head == null) return null;
		// ListNode dummy = new ListNode(0);
		// ListNode ans = reverseListH(head, dummy);
		// ans.next = null;
		// return dummy.next;
		return reverseListRec(head);

		// Iterative: Working!
		// return reverseListIterative(head);
	}

	public ListNode reverseListIt(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = slow;
			slow = head;
			head = temp;
		}
		return slow;
	}

	public ListNode reverseListRec(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode t = reverseListRec(head.next);
		head.next.next = head;
		head.next = null;
		return t;
	}

	public ListNode reverseListIterative(ListNode head) {
		if (head == null || head.next == null)
			return head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head.next != null) {
			stack.push(head);
			head = head.next;
		}
		ListNode temp = head;
		while (!stack.isEmpty()) {
			head.next = stack.pop();
			head = head.next;
		}
		head.next = null;
		return temp;
	}

	public ListNode reverseListRecursive(ListNode head) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0);
		ListNode ans = reverseListH(head, dummy);
		ans.next = null;
		return dummy.next;
	}

	public ListNode reverseListH(ListNode head, ListNode dummy) {
		if (head.next == null) {
			dummy.next = head;
			return head;
		}
		reverseListH(head.next, dummy).next = head;
		return head;
	}
}
