package LeetCode;

import Utilities.ListNode;

public class Prob234_LinkedListPalindrome {
	
	public static void main (String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(1);
//		node.next.next.next.next = new ListNode(1);
		System.out.println(node);
		System.out.println(isPalindrome(node));
	}
	
	public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        
        // if even # of nodes: slow points to the start of the second half
        // otherwise points to the mid element
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next; // if odd go to the start of the next node
        
        ListNode reversed = reverse(slow);
        System.out.println(reversed);
        boolean ans = false;
        
        while (reversed != null) {
        	System.out.println(head.val + " " +reversed.val);
            if (head.val == reversed.val) ans = true;
            else {
                ans = false;
                break;
            }
            head = head.next;
            reversed = reversed.next;
        }
        if (fast == null) {
        	if (head != slow) ans = false;
        }
    	else {
    		if (head.next != slow) ans = false;
    	}
        if (reversed != null) ans = false;
        
        return ans;
    }
    
    public static ListNode reverse(ListNode node) {
        if (node == null) return null;
        ListNode temp = null;
        while (node != null) {
            ListNode n = node.next;
            node.next = temp;
            temp = node;
            node = n;
        }
        return temp;
    }
}
