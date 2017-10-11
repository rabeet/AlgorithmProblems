package LeetCode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

import Utilities.ListNode;

interface i {
	int i = 2;
}
public class Prob61_RotateList implements Cloneable {
	
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		Prob61_RotateList pr = new Prob61_RotateList();
		ListNode r2 = pr.rotateRight(l, 6);
		System.out.println(r2);
	}

	ListNode newh = null;
	
	/*
	 * 4 phase approach:
	 * 1. FIND SIZE
	 * 2. CONNECT THE TAIL TO THE START
	 * 3. GET THE RETURN NODE
	 * 4. PERFORM THE SPLIT AT size - k%size
	 * 
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0 || head.next == null) return head;
		ListNode temp = head;
		int track = 0, size = 1;
		ListNode ans = null;
		// FIND SIZE
		while (temp.next != null){
			temp = temp.next;
			size++;
		}
		
		// CONNECT THE TAIL TO THE START
		k = size - k%size;
		temp.next = head;
		temp = head;
		
		// GET THE RETURN NODE
		while (track < k) {
			temp = temp.next;
			track++;
		}
		ans = temp;
		
		// PERFORM THE SPLIT AT size - k%size
		while (true) {
			if (k == 1)
				break;
			head = head.next;
			k--;
		}
		head.next = null;
		return ans;
	}

	public ListNode rotateRightFlawed(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		int size = findLength(head);

		// reverse the whole list
		reverse(head, size);
		head = newh;
		// reverse the first k elements
		
		reverse(head, k);
		head = newh;
		ListNode ans = head, temp = ans;
//		// reverse the end elements
		int t = 0;
		while (t < k) {
			if (t == k-2) temp = head;
			head = head.next;
			t++;
		}
		reverse(head, k);
		t = 0;
		while (temp != null) {
			
			if (t >= k-1) break;
			t++;
			temp = temp.next;
		}
		temp.next = newh;
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
