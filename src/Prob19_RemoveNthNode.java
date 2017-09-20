
public class Prob19_RemoveNthNode {
	
	public static ListNode deleteNthToLastNode(ListNode node, int n) {
		if (node == null || n < 1) return node;
		ListNode dummy = node;
		ListNode runner = node; // fast runner
		ListNode walker = node; // slow runner
		
		// distance of n b/w runner and node
		for (int i = 0; i < n-1; i++) {
			if (runner == null)
				return null;
			runner = runner.next;
		}
		if (runner.next == null) {
			return node.next;
		}
		int test = 0;
		while (runner.next != null) {
			if (test != 0)
				walker = walker.next;
			node = node.next;
			runner = runner.next;
			test++;
		}
		// runner points to the end
		// node points at the node to be removed
		// walker points to the node before node
		
		walker.next = node.next;
		return dummy;
	}

}
