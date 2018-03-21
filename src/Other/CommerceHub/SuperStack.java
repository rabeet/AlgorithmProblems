package Other.CommerceHub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SuperStack {

	public static void main(String[] args) {
//		superStack(new String[] {"push 4","pop","push 3","push 5","push 2","inc 3 1","pop","push 1","inc 2 2","push 4","pop","pop"} );
		superStack(new String[] {"push 1","push 2", "push 3", "push 4", "inc 4 1", "pop", "pop", "pop", "pop"} );
	}
	
	static void superStack(String[] operations) {
//        SuperStackUsingList stack = new SuperStackUsingList();
        SuperStackImpl stack = new SuperStackImpl();
	    for (String operation : operations) {
            String[] tests = operation.split(" ");
            switch(tests[0]) {
                case "push":
                    Integer numToPush = new Integer(tests[1]);
                    stack.push(numToPush);
                    break;
                case "pop":
                    Integer popped = stack.pop();
                    break;
                case "inc":
                    Integer e = new Integer(tests[1]);
                    Integer k = new Integer(tests[2]);
                    stack.inc(e,k);
                    break;
            }
            System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
        }
	}
	
	/*
	 * Based on an array list as the internal data structure
	 */
	static class SuperStackUsingList {
		private List<Integer> list;
		
		public SuperStackUsingList() {
			this.list = new ArrayList<>();
		}
		public Integer pop() {
			return list.remove(0);
		}
		
		public void push(Integer item) {
			list.add(0, item);
		}
		
		public Integer peek() {
			return list.get(0);
		}
		// Time: O(e), Space: O(1)
		public void inc(int e, int k) {
			int len = list.size();
			for (int i = len-e; i < len; i++) {
				Integer removed = list.remove(i);
				list.add(i, removed+k);
			}
		}
		public boolean isEmpty() {
			return list.isEmpty();
		}
	}
	
	/*
	 * Based on stack class
	 */
	static class SuperStackImpl extends Stack<Integer> {
		
		/**
		 * Add k to last e elements of the stack
		 * @param e - last e elements
		 * @param k - add k
		 */
		
		private Stack<Integer> innerStack;
		
		public SuperStackImpl() {
			this.innerStack = new Stack<Integer>();
		}
		// Time: O(n), Space: O(n)
		public void inc(int e, int k) {
			int n = this.size();
			while (n > e) {
				innerStack.push(this.pop());
				n--;
			}
			while (e > 0) {
				innerStack.push(this.pop()+k);
				e--;
			}
			n = innerStack.size();
			for (int i = 0; i < n; i++) {
				this.push(innerStack.pop());
			}
		}
		
	}

}

/*
 * Easy way: O(n) time, O(n) space
 * 
 * n = stack size
 * stack1 = basic stack of type E
 * while (n > e) {
 * pop from stack, push to stack1
 * n--;
 * }
 * while (e > 0) {
 * pop from stack, add k, push to stack1
 * e--;
 * }
 * STACK should be empty at this point
 * push all from stack1 to stack
 * STACK1 should be empty at this point
 */

/*
 * stack = 2 -> 1 -> 4 | EMPTY,
 * inc (2, 1)
 * stack1= 4 -> 2 -> 3
 * stack = 3 -> 2 -> 4
 * 
 */
