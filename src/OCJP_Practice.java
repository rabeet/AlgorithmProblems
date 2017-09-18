import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Doll {
	String name;

	Doll(String nm) {
		this.name = nm;
	}

	void m() throws IOException {

	}
}

class Barbie extends Doll {
	
	private static final byte satring = 5;
	
	static {
	}

	void m() {
		System.out.println("barbie");
		
	}

	Barbie() {
		super("a");
	}

	Barbie(String nm) {
		this();
	}
}

class Widget {
	int MAX; // 1
	static String CLASS_GUID; // 2

	Widget() {
		CLASS_GUID = 2 + "D";
		MAX = 2;
	}

	Widget(int k) {
		CLASS_GUID = 2 + "D";
	}
}

class ABCD extends OCJP_Practice {
	int x = 10;
	static int y = 20;

	void m() throws Exception {
		
		Doll d = new Doll("ad");
		Barbie b = new Barbie("S");
		d = b;
		System.out.println("ABCD");
		throw new Exception();
	}

	public static int main(String[] args, String[] args1) {
		return y = 2;
		

	}
}

class MNOP extends ABCD {
	int x = 30;
	static int y = 40;

	void m() {
		System.out.println("MNOP");
	}
}

public class OCJP_Practice {

	public static int doIt() { // NOT RETURN ANYTHING BUT
								// THROWING EXCEPTION WTF!!!!!
		return 2;
	}

	int int1 = doIt();

	static String[] days = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) throws IOException {
		
		System.out.println("HI");
		
	}

	public static void random(Integer s) {

	}

	public List<List<Integer>> three_Sum(int[] arr) {
		if (arr == null || arr.length < 3)
			return null;

		List<List<Integer>> list = new ArrayList<>();

		return list;
	}

	/**
	 * Returns a string representation of the first argument in the radix
	 * specified by the second argument.
	 *
	 * <p>
	 * If the radix is smaller than {@code Character.MIN_RADIX} or larger than
	 * {@code Character.MAX_RADIX}, then the radix {@code 10} is used instead.
	 *
	 * <p>
	 * If the first argument is negative, the first element of the result is the
	 * ASCII minus character {@code '-'} (<code>'&#92;u002D'</code>). If the
	 * first argument is not negative, no sign character appears in the result.
	 *
	 * <p>
	 * The remaining characters of the result represent the magnitude of the
	 * first argument. If the magnitude is zero, it is represented by a single
	 * zero character {@code '0'} (<code>'&#92;u0030'</code>); otherwise, the
	 * first character of the representation of the magnitude will not be the
	 * zero character. The following ASCII characters are used as digits:
	 *
	 * <blockquote> {@code 0123456789abcdefghijklmnopqrstuvwxyz} </blockquote>
	 *
	 * These are <code>'&#92;u0030'</code> through <code>'&#92;u0039'</code> and
	 * <code>'&#92;u0061'</code> through <code>'&#92;u007A'</code>. If
	 * {@code radix} is <var>N</var>, then the first <var>N</var> of these
	 * characters are used as radix-<var>N</var> digits in the order shown.
	 * Thus, the digits for hexadecimal (radix 16) are {@code 0123456789abcdef}.
	 * If uppercase letters are desired, the
	 * {@link java.lang.String#toUpperCase()} method may be called on the
	 * result:
	 *
	 * <blockquote> {@code Integer.toString(n, 16).toUpperCase()} </blockquote>
	 *
	 * @param i
	 *            an integer to be converted to a string.
	 * @param radix
	 *            the radix to use in the string representation.
	 * @return a string representation of the argument in the specified radix.
	 * @see java.lang.Character#MAX_RADIX
	 * @see java.lang.Character#MIN_RADIX
	 */
	public static String toString(int i, int radix) {

		if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
			radix = 10;

		char buf[] = new char[33];
		boolean negative = (i < 0);
		int charPos = 32;

		if (!negative) {
			i = -i;
		}

		while (i <= -radix) {

			System.out.println((buf[charPos--] = digits[-(i % radix)]));
			i = i / radix;
			System.out.println(i);
		}
		System.out.println(buf[charPos] = digits[-i]);

		if (negative) {
			buf[--charPos] = '-';
		}

		return new String(buf, charPos, (33 - charPos));
	}

}
