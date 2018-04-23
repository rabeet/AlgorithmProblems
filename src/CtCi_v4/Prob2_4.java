package CtCi_v4;

import Utilities.Node;

public class Prob2_4 {

	
	/*
	 * add two digits in reverse order in linked list
	 * return it in reversed form
	 */
	public static void main(String[] args) {
		Node n1 = Node.populateList(3);
		Node n2 = Node.populateList(3);
		System.out.println(n1 + "+" + n2 + ": " +addTwoNumbersReverse(n1,n2));
	}

	public static Node addTwoForward(Node n1, Node n2) {
		Node node = new Node(-1);
		Node dummy = node;
		int num1 = 0;
		int num2 = 0;
		while (n1 != null) {
			num1 = num1*10 + n1.data;
			n1 = n1.next;
		}
		while (n2 != null) {
			num2 = num2*10 + n2.data;
			n2 = n2.next;
		}
		num1 += num2;
		Node p1 = null, p2 = null;
		while (num1 != 0) {
			node.next = new Node(num1%10);
			
			node = node.next;
			num1 /= 10;
		}
		return dummy.next;
	}
	
	public static Node addTwoNumbersReverse(Node n1, Node n2) {
		Node node = new Node(-1);
		Node dummy = node;
		int carry = 0;
		
		while (n1 != null || n2 != null) {
			
			int x = n1 != null ? n1.data : 0;
			int y = n2 != null ? n2.data : 0;
			
			node.next = new Node((carry + x + y) % 10) ;
			carry = (carry+x+y)/10;
			
			if (n1 != null) n1 = n1.next;
			if (n2 != null) n2 = n2.next;
			node = node.next;
		}
		
		if (carry == 1)
			node.next = new Node(1);
		
		return dummy.next;
	}
	
}
