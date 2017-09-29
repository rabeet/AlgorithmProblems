package LeetCode;
public class Prob326_PowerOfThree {
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree((int)Math.pow(3, 11)));
		System.out.println(isPowerOfThree2(244));
	}
	
	public static boolean isPowerOfThree(int n) {
		if (n == 0)
			return false;
		double num = Math.log(n)/Math.log(3);
//		num = Math.round(num);
		return (Math.abs(Math.pow(3, num)-n) <= 0.000000001);
	}
	
	public static boolean isPowerOfThree2(int n) {
		return n == 0 ? false : (n == 1) ? true:isPowerOfThree2(n/3);
	}
}
