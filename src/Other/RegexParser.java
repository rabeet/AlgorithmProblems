package Other;

public class RegexParser {

	public static void main(String[] args) {
		System.out.println(isMatch("acd", "ab*c."));
	}

	static boolean isMatch(String text, String pattern) {
		if (text == null || text.isEmpty() && pattern == null || pattern.isEmpty())
			return true;
		if (pattern == null || pattern.isEmpty())
			return true;
		if (text == null || text.isEmpty() && !remains(pattern, 0))
			return true; // TODO: also a case to handle somethiong like b*
		return isMatch(text, pattern, 0, 0);
	}

	static boolean isMatch(String text, String pattern, int i, int j) {
		if (i >= text.length() && !remains(pattern, j))
			return true; // if my text has been traversed and nothing
							// significant is left in the pattern: TRUE
		else if (i >= text.length() && remains(pattern, j))
			return false;
		if (j >= pattern.length())
			return false;
		if (text.charAt(i) == pattern.charAt(j))
			return isMatch(text, pattern, i + 1, j + 1);
		else if (pattern.charAt(j) == '.')
			return isMatch(text, pattern, i + 1, j + 1);
		else if (pattern.charAt(j) == '*' && j == 0)
			return isMatch(text, pattern, i + 1, j + 1);
		else if (pattern.charAt(j) == '*' && text.charAt(i) == pattern.charAt(j - 1))
			return isMatch(text, pattern, i + 1, j);
		else if (pattern.charAt(j) == '*' && text.charAt(i) != pattern.charAt(j - 1))
			return isMatch(text, pattern, i + 1, j);
		else if (pattern.charAt(j) == '*')
			return isMatch(text, pattern, i-1, j);
		return false;
	}

	static boolean remains(String pattern, int i) {
		for (; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '*')
				continue;
			else
				return true;
		}
		return false;
	}
}
