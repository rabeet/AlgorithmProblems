package LeetCode;
public class Prob21_MergeTwoSortedLists {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(2);
//		node.next = new ListNode(4);
		ListNode node1 = new ListNode(1);
//		node1.next = new ListNode(52);
//		node1.next.next = new ListNode(23);
		ListNode ns = mergeTwoLists(node, node1);
		while (ns != null) {
			System.out.println(ns.val);
			ns = ns.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode node, copy;
		if (l1.val <= l2.val) {
			node = l1;
			l1 = l1.next;
		} else {
			node = l2;
			l2 = l2.next;
		}
		copy = node;
		for (;;) {
			if (l2 == null && l1 == null)
				break;
			else if(l2 != null && l1 == null) {
				node.next = l2;
				l2 = l2.next;
			}
			else if(l1 != null && l2 == null) {
				node.next = l1;
				l1 = l1.next;
			}
			else if (l1.val <= l2.val) {
				node.next = l1;
				l1 = l1.next;
			}
			else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		return copy;
	}
	
	static class ListNode {
		ListNode next;
		int val;
		public ListNode (int val) { this.val = val;}
	}

}
