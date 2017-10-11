package LeetCode;

import Utilities.ListNode;

public class Prob445_AddTwoNumbersII {
	
    static int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode t1 = l1, t2 = l2;
        // get int value from list 1
        // get int value from list 2
        // add them together and wrap them in a list format
        // TC: O(Max(n,m)), SC: O(1)
        
        // append 0s at the start of the list that is smaller
        // instead of appending just keep a size int and do it that way
        int size = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {l1 = l1.next;size++;}
            if (l2 != null) {l2 = l2.next;size--;}
        }
        ListNode ans = populateList(t1,t2,size);
        if (carry != 0) {
            ListNode anst = new ListNode(carry);
            anst.next = ans;
            carry = 0;
            return anst;
        } else return ans;
    }
    
    
    // (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    
    public ListNode populateList(ListNode l1, ListNode l2, int num) {
        
        if (l1 == null && l2 == null) {
            return  null;
        } 
        ListNode temp = new ListNode(0);
        temp.next = num > 0? populateList(l1.next, l2, num-1) : 
        num < 0 ? populateList(l1, l2.next, num+1) : populateList(l1.next,l2.next, num);
        if (num > 0) {temp.val = (l1.val + carry)%10; carry = (l1.val + carry)/10;}
        else if (num < 0) {temp.val = (l2.val + carry)%10; carry = (l2.val + carry)/10;}
        else {temp.val = (l1.val+l2.val+carry)%10; carry = (l1.val + l2.val + carry)/10;}
        return temp;
    }

}
