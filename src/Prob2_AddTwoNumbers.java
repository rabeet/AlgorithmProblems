import java.math.BigInteger;

// https://leetcode.com/problems/add-two-numbers/#/description

public class Prob2_AddTwoNumbers {
	
	public static void main(String args[]) {
		ListNode n1 = new ListNode(2); ListNode n2 = new ListNode(4); ListNode n3 = new ListNode(3);
		ListNode m1 = new ListNode(5); ListNode m2 = new ListNode(6); ListNode m3 = new ListNode(4);
		
		n1.next = n2; n2.next = n3;
		m1.next = m2; m2.next = m3;
		
		ListNode ans = addTwoNumbers(n1,m1);
		
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = "";
		String num2 = "";

		do {
			num1 = l1.val + num1;

			l1 = l1.next;
		} while (l1 != null);

		do {
			num2 = l2.val + num2;

			l2 = l2.next;
		} while (l2 != null);

		BigInteger bi1 = new BigInteger(num1);
		String num3 = bi1.add(new BigInteger(num2)).toString();
		// System.out.println(num3);

		// String num3 = ""+n3;
		ListNode node = new ListNode(Integer.parseInt(""
				+ num3.charAt(num3.length() - 1)));
		ListNode ans = node;
		for (int i = num3.length() - 2; i >= 0; i--) {
			node.next = new ListNode(Integer.parseInt("" + num3.charAt(i)));
			node = node.next;
		}
		return ans;
	}
	
}

class ListNode {
	ListNode next;
	int val;
	ListNode(int a) {
		this.val = a;
	}
}
