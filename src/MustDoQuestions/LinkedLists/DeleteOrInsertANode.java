package MustDoQuestions.LinkedLists;

import Utilities.ListNode;

public class DeleteOrInsertANode {
	
	public static void main(String[] args) {
		ListNode n = new ListNode(5);
		n.next = new ListNode(4);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(2);
		System.out.println(delete(n, 2));
		System.out.println(delete(n, 5));
		System.out.println(delete(n, 4));
		
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(3);
		n1.next.next = new ListNode(5);
		n1.next.next.next = new ListNode(6);
		System.out.println(insertSortedOrder(n1, 2));
		System.out.println(insertSortedOrder(n1, 9));
		System.out.println(insertSortedOrder(n1, 0));
		System.out.println(insertSortedOrder(n1, 4));
	}
	
	// 5 4 3 2, del 4 -> 5 3 2
	// 5 4 3 2, del 5 -> 4 3 2
	static public ListNode delete(ListNode n, int val) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		dummy.next = n;
		while (n != null) {
			if (val == n.val) 
				{
				dummy.next = n.next;
				break;
				}
			n = n.next;
			dummy = dummy.next;
		}
		return temp.next;
	}
	
	public static ListNode insertSortedOrder(ListNode n, int val) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		dummy.next = n;
		while (n != null) {
			if (val < n.val) {
				ListNode t = new ListNode(val);
				dummy.next = t;
				t.next = n;
				return temp.next;
			}
			n = n.next;
			dummy = dummy.next;
		}
		dummy.next = new ListNode(val); // <- end has been reached w/out insertion
		return temp.next;
	}
	
}
