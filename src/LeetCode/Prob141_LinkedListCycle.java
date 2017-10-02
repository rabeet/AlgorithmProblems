package LeetCode;

public class Prob141_LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		// 2 pointer approach. increase p1 by one speed and increase p2 by 2
		// speed. if they meet hen true otherwise false
		ListNode p1 = head, p2 = head;
		int temp = 0;
		while (p1 != null && p2 != null) {
			if (p1 == p2 && temp != 0)
				return true;
			temp++;
			p1 = p1.next;
			p2 = p2.next;
			if (p2 != null)
				p2 = p2.next;
		}
		return false;
	}

}
