package LeetCode;

public class Prob9_PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
	
	/*
	 * Determine if a number is palindromic w/out extra space:
	 * num mod 10 yields unit's number
	 * Possible if using 2 more int?
	 * while x != 0
	 * mod input by 10 to get remainder.
	 * output*10 + remainder will be the output
	 * 
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		int input = x;
		int output = 0;
		while (x != 0) {
			output = output*10+(x%10);
			x /= 10;
		}
		return input == output;
	}

}
