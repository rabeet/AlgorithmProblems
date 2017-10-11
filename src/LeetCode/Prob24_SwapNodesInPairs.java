package LeetCode;

public class Prob24_SwapNodesInPairs {
	
	public static void main (String[] args) {
		
	}
	
	public ListNode swapPairs(ListNode node) {
		
		ListNode dummy = new ListNode(-1);
		dummy.next = node; // dummy -> 1 -> 2 -> 3 -> 4
		ListNode current = dummy; // dummy
		ListNode first = null;
		ListNode second = null;
		
		while (current.next != null && current.next.next != null) {
			first = current.next; // 1
			second = current.next.next; // 2
			first.next = second.next; // 1 -> 3
			current.next = second; // dummy -> 2
			current.next.next = first; // 2 -> 1
			
			current = current.next.next; // dummy = 1
			
			// after 1st iter: dummy -> 2 -> 1 -> 3 -> 4
		}
		
		
		
		return dummy.next;
	}
	
	public ListNode swapPairsRab(ListNode node) {
		int count = 0;
		ListNode copy = null;
		while (node.next != null) {
			ListNode nn = node.next;
			if (count == 0) {
				copy = nn;
			}
			nn.next = node;
			node.next.next = node;
		}
		return copy;
	}
	
	private class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) { this.val = val; }
	}
}
