package LeetCode;

public class Prob189_RotateArray {

	public void rotate(int[] nums, int k) {

		if (nums == null || nums.length <= 1 || k == 0)
			return;

		// use extra array: the rotated position is (i+k) MODULO length
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = ans[i];
		}

		// 2 pointer approach:
		// p1 starts at 0, p2 starts at k. keep swapping p1 and p2 until you
		// reach the end of the array
		// 1 2 3 4 5 6 7, k = 2 --> 6 7 1 2 3 4 5
		// 6 7 3 4 5 1 2 -->
		// 6 7 3 4 1 5 2
		// 6 7 3 1 4 5 2
		// 6 7 1 3 4 5 2
		// 6 7 1 2 3 4 5

		// O(n*k) method -- easiest
		// O(n) method with O(n) space complexity
		// O(n) method with O(1) space complexity:
		/*
		 * swap the last k elements with the first k elements -> O(k) and then
		 * shift everything to k+1 -> O(n) : O(n)
		 */

		// int[] ans = new int[nums.length];
		// for (int i = k, j = 0; i < nums.length; i++, j++) {
		// ans[i] = nums[j];
		// }
		// for (int i = 0, j = nums.length-k; i < k; i++, j++) {
		// ans[i] = nums[j];
		// }

		// for (int i = 0; i < nums.length; i++) {
		// nums[i] = ans[i];
		// }
	}
}
