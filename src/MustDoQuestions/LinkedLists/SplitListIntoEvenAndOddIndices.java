package MustDoQuestions.LinkedLists;

import java.util.ArrayList;
import java.util.List;

import Utilities.ListNode;

public class SplitListIntoEvenAndOddIndices {

	public static void main(String[] args) {
		
		// PART 1: split a list into two lists with one being even indices and the other 
		// being odd indices
		ListNode n = ListNode.populateList(10);
		System.out.println(n);
		System.out.println(split(n));
		
		// PART 2: Group all ODD nodes together and then even nodes into one single list
		ListNode n1 = ListNode.populateList(6);
		System.out.println(oddEvenList(n1));
	}
	
	/*
	 * 1 - 2 - 3 - 4 - 5
	 * 1 - 3 - 5 *ODD working
	 * 2 - 4
	 */
	static public List<ListNode> split(ListNode n) {
		List<ListNode> list = new ArrayList();
		ListNode even = new ListNode(0);
		ListNode odd = new ListNode(0);
		ListNode te = even;
		ListNode to = odd;
		while (n != null && n.next != null) {
			even.next = n;
			n = n.next;
			odd.next = n;
			n = n.next;
			even = even.next;
			odd = odd.next;
		}
		even.next = n;
		odd.next = null;
		list.add(te.next);
		list.add(to.next);
		return list;
	}
	
	/*
	 * 1 - 2 - 3 - 4 - 5 --> 1 - 3 - 5 - 2 - 4 - NULL
	 */
	static public ListNode oddEvenList(ListNode n) {
		ListNode even = new ListNode(0);
		ListNode odd = new ListNode(0);
		ListNode te = even;
		ListNode to = odd;
		
		while (n != null && n.next != null) {
			odd.next = n;
			n = n.next;
			even.next = n;
			n = n.next;
			odd = odd.next;
			even = even.next;
		}
		even.next = null;
		if (n == null) {
			odd.next = te.next;
		} else {
			odd.next = n;
			odd = odd.next;
			odd.next = te.next;
		}
		return to.next;
	}

}
