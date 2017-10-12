package Utilities;


public class ListNode {
	public ListNode next;
	public int val;
	public ListNode(int a) {
		this.val = a;
	}
	
	public String toString() {
		String s = ""+this.val;
		ListNode n = this;
		while (n.next != null) {
			n = n.next;
			s += "->"+n.val;
		}
		return s;
	}
	
	public static ListNode populateList(int limit) {
		ListNode node = new ListNode((-1));
		ListNode ret = node;
		for (int i = 1; i <= limit; i++) {
			node.next = new ListNode((i));
			node = node.next;
		}
		return ret.next;
	}
}

