package LeetCode;

public class Prob5_LongestPalindromicSubstring {

	public static void main(String args[]) {
		String s = "abasbaxa";
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome("123321"));
		System.out.println(longestPalindrome("avadagad"));
	}

	public static String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			expandAroundCenter(s, i, i);
			expandAroundCenter(s, i, i + 1);
		}
		return s.substring(start, start + stop);
	}

	private static int start = Integer.MIN_VALUE, stop;

	private static void expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		if (r - l - 1 > stop) {
			start = l + 1;
			stop = r - l - 1;
		}
	}
}
