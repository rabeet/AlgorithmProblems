package LeetCode;

public class Prob10_RegexMatching {

	public static boolean isMatch(String text, String pattern) {
		return isMatch(text, pattern, 0, 0);
	}

	private static boolean isMatch(String text, String pattern, int ti, int pi) {
		// your code goes here
		if (pi >= pattern.length() && ti >= text.length())
			return true;
		if (pi >= pattern.length() && ti < text.length())
			return false;
		if (pi < pattern.length() && ti >= text.length()) {
			if (pattern.charAt(pi) == '*') {
				return isMatch(text, pattern, ti, pi + 1);
			}
			if (pi + 1 < pattern.length() && pattern.charAt(pi + 1) == '*') {
				return isMatch(text, pattern, ti, pi + 2);
			} else {
				return false;
			}
		}

		// they are both under their threshold now
		if (pattern.charAt(pi) == '.' || pattern.charAt(pi) == text.charAt(ti)) // need
																				// to
																				// worry
																				// about
																				// .*
			return isMatch(text, pattern, ti + 1, pi + 1);

		if (pattern.charAt(pi) == '*') {
			if (ti >= text.length())
				return true;
			else if (text.charAt(ti) == pattern.charAt(pi - 1) || pattern.charAt(pi - 1) == '.')
				return isMatch(text, pattern, ti + 1, pi);
			else
				return isMatch(text, pattern, ti, pi + 1);
		}

		if (text.charAt(ti) != pattern.charAt(pi)) {
			if (pi < pattern.length() - 1) {
				if (pattern.charAt(pi + 1) == '*')
					return isMatch(text, pattern, ti, pi + 1);
				else
					return false;
			} else {
				return false;
			}
		}
		return isMatch(text, pattern, ti + 1, pi + 1); // should never reach
	}

}
