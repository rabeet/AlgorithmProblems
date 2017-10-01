package LeetCode;

public class Prob268_MissingNumber {
	public int missingNumber(int[] nums) {
		if (nums == null)
			return 0;
		// basic traversal - keep traversing until difference of 1 is broken (if
		// sorted)
		// if not sorted -> keep 2 variables:
		// add i to one var and add nums[i] to the other
		// the difference b/w the 2 is the answer
		int n1 = 0, n2 = 0;
		for (int i = 0; i < nums.length; i++) {
			n1 += i + 1;
			n2 += nums[i];
		}
		return n1 - n2;
	}
}
