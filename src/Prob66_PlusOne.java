import java.util.Arrays;
import java.util.Stack;

public class Prob66_PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9})));
	}
	
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
