package LeetCode;

import Utilities.ListNode;

public class Prob160_IntersectionOfTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        // size difference:
        ListNode h1 = headA, h2 = headB;
        int size = 0;
        while (headA != null || headB != null) {
            if (headA != null) {headA = headA.next; size++;}
            if (headB != null) {headB = headB.next; size--;}
        }
        
        // main phase:
        while (h1 != null && h2 != null) {
            // traversal phase
            if (size > 0) {h1 = h1.next; size--;}
            else if (size < 0) {h2 = h2.next; size++;}
            // find phase
            else {
                if (h1 == h2) return h1;
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        return null;
    }
}
