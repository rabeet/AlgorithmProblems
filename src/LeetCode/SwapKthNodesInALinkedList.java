package LeetCode;

public class SwapKthNodesInALinkedList {

	public static void main(String[] args) {
		
	}
	
	
	/*
	 * TESTING:
	 * null = null
	 * 1; 1 -> 1
	 * 1,2; 1 -> k = 1, k2 = 2, k3 = 1, l_kth = 2, k4 = null, k1 = null
	 * 
	 * 2 -> 2
	 * 1 -> null
	 * 1 -> 1
	 */
	public static ListNode swap(ListNode head, int k) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode node = head, kth = null, l_kth = null, k1 = null, k2 = null, k3 = null, k4 = null;
		int l = 1;
		while (node != null) {
			if (l == k) kth = node;
			else if(l == k-1) k1 = node;
			else if (l == k+1) k2 = node;
			l++;
			node = node.next;
		}
//		l--;
		assert k <= l;
		node = head;
		int i = 1;
		while (node != null) {
			if (l-k == i) l_kth = node;
			else if (l-k-1 == i) k3 = node;
			else if (l-k+1 == i) k4 = node;
			i++;
			node = node.next;
		}
		
		// swaps
		if (k1 != null) k1.next = l_kth;
		l_kth.next = k2;
		kth.next = k4;
		k3.next = kth;
		
		return head;
	}

}

// 1 - 2 - 3 - 4, k = 2
// 1 -> 3 -> 2 -> 4

// Easy way: T: O(n), S: O(n)
// load all them in an Array list and manipulate kth elements of
// list from both sides.

// A bit harder: T: O(n), S: O(1)
// find num of nodes.
// save the references of the before and after nodes of the kth nodes from both sides
// perform the swaps

// At most have to do 4 swaps. k1.before. k1.after. k2.before, k2.after

/*
l = length of list.

save k-1th node as k1
save k+1th node as k2
save l-k-1th node as k3
save l-k+1th node as k4
save k
save l-k

k1.next = l-k
l-k.next = k2
k.next = k4
k3.next = k


*/