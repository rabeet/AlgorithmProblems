package CtCi_v4;

public class Prob5_2 {

	/*
	 * 5.2: Given a decimal num that is passed in as a string, print its bin
	 * representation.
	 * 
	 * return an error if its a decimal number otherwise
	 * print the binary representation
	 */
	public static void main(String[] args) {
		System.out.println(toBinary("123.12"));
		System.out.println(toBinary("4.00"));
		System.out.println(toBinary("abc"));
		System.out.println(toBinary("-12"));
	}
	
	public static String toBinary(String num) {
		if (num.indexOf(".") != -1) return "ERROR";
		// Check for bounds
//		TODO: Look at better implementation in the book
		Long n;
		try {
			n = Long.parseLong(num);
		} catch (NumberFormatException e) {
			return "ERROR";
		}
		if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) return "ERROR";
		long nl = n;
		Integer nb = (int)nl;
		System.out.println(nb);
		return Integer.toBinaryString(nb);}

}
