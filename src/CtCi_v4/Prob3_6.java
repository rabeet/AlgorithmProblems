package CtCi_v4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prob3_6 {
	/*
	 * 3.6: Write a prog to sort a stack in asc order
	 * can only use push, pop, peek, is empty
	 * 
	 * Easy way would be to pop out all items. sort them and put them back in the stack
	 * O(n) space.
	 * O(nlogn) time
	 * 
	 * Is it possible to do this in O(1) space?
	 * dont think so
	 */

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(2);
		stack.push(5);
		stack.push(1);
		sortStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	public static void sortStack(Stack<Integer> stack) {
		List<Integer> list = new ArrayList();
		
		for (;!stack.isEmpty();) {
			list.add(stack.pop());
		}
		Object[] arr = list.toArray();
		list = null;
		Arrays.sort(arr);
		for (int i = arr.length-1; i>= 0; i--) {
			stack.push((int)arr[i]);
		}
	}

}
