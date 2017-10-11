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
}

