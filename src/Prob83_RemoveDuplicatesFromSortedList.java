public class Prob83_RemoveDuplicatesFromSortedList {
	
	public static void main(String[] args) {
		ListNode node = null;
//		node.next = new ListNode(1);
//		node.next.next = new ListNode(1);
//		node.next.next.next = new ListNode(1);
		
		ListNode n = deleteDuplicates(node);
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode node = head;
		ListNode uniques = head;
		int unique = head.val;
		while (head != null) {
			if (head.val != unique) {
				uniques.next = head;
				uniques = uniques.next;
				unique = head.val;
			}
			head = head.next;
		}
		uniques.next = null;
		return node;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
