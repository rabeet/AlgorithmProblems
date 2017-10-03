package LeetCode;

public class Prob61_RotateList {

	public static void main(String[] args) {
		
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		Prob61_RotateList pr = new Prob61_RotateList();
		ListNode r = pr.rotateRight(l, 2);
		System.out.println(r);
	}

	ListNode newh = null;

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		int size = findLength(head);

		// reverse the whole list
		reverse(head, size);
		head = newh;
		// reverse the first k elements
		
		reverse(head, k);
		head = newh;
		ListNode ans = head;
//		// reverse the end elements
		int t = 1;
		while (t < k) {
			head = head.next;
			t++;
		}
		reverse(head, k);
		head.next = newh;
		return ans;
	}

	public int findLength(ListNode head) {
		int i = 1;
		while (head != null) {
			head = head.next;
			if (head != null)
				i++;
		}
		return i;
	}

	// 1 - 2 - 3 - 4; k =2 --> 3 - 4 - 1 - 2
	/*
	 * 4-3-2-1 3-4-null
	 */
	public void reverse(ListNode head, int end) {
		// end when a counter reaches the end node
		int track = 1;
		ListNode th = head;
		while (th != null) {
			th = th.next;
			if (track < end) track++;
			else break;
		}
		track = 1;
		ListNode temp = th;
		while (head != null) {
			
			ListNode n = head.next;
			head.next = temp;
			temp = head;
			newh = head;
			head = n;
			if (track < end) track++;
			else break;
		}
	}

}
