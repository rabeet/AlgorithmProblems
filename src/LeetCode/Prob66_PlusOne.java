package LeetCode;
import java.util.Arrays;
import java.util.Stack;

public class Prob66_PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9})));
	}
	
	/*
	 * Algo:
		check for null or empty
		arr
		Stack q
		boolean summed = false;
		for arr i: last -> 0
			if (summed == false)
				if arr[i] + 1 == 10 then
					and enqueue 0
					if i == 0
						enque 1
				else
					enqueue arr[i]+1
					summed = true
			else
				enqueue arr[i]
		
		new arrans[q.size()]
		for i:0 -> q.size()
			arrans[i] = q.deque();
		return arrans;
		
		arr: [9]
		Q: 1 0
		arrans: 1,0
		
		arr: [1,0,1]
		S:2,0,1
		
		arrans:1,0,2
		
		arr: [9,9,9,9]
		Q: 0
		Q: 0 0
		Q: 0 0 0
		Q: 1 0 0 0 0
		
		arrans: 1,0,0,0,0
		
		arr: [9,8,9]
		
		Q: 0
		Q: 9 0
		Q: 9 9 0
		arrans: [9,9,0]
	 */
	
	public static int[] plusOne(int[] digits) {
		if (digits == null) return new int[1];
		if (digits.length < 1) return new int[1];
		boolean summed = false;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = digits.length-1; i >= 0; i--) {
			assert digits[i] > -1 && digits[i] < 10;
			if (summed == false) {
				if (digits[i] + 1 == 10) {
					stack.push(0);
					if (i == 0) stack.push(1);
				} else {
					stack.push(digits[i]+1);
					summed = true;
				}
			} else {
				stack.push(digits[i]);
			}
		}
		int[] arrans = new int[stack.size()];
		for (int i = 0; i < arrans.length; i++) arrans[i] = stack.pop();
		return arrans;
	}

}
