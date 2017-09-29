package LeetCode;

public class Prob342_PowerOfFour {

	/*
	 * 
	 * Prob 342 - Power of four Given an integer, write a function to determine
	 * if it is a power of four.
	 * 
	 * Can you have a negative number as a power of four? 4*4*4 = 64 is a power
	 * of four
	 * 
	 * We an do the identity: log_4 (n) = x --> 4^x = n
	 * 
	 * log_a (b) can be represented as log b / log a
	 * 
	 * So log 64 / log 4 = 3
	 * 
	 * we can also do log x % log 4 == 1
	 * 
	 */
	public static void main(String args[]) {
		System.out.println(isPowerOfFour(0));
	}

	public static boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		double x = (Math.log10(num)) / (Math.log10(4));
		double y = Math.pow(4, Math.round(x));
		return Math.abs(num - y) <= 0.000001;
	}

}
