package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob17_LetterCombinationsOfPhoneNumber {

	static Map<Character, String[]> map;

	static {
		map = new HashMap<Character, String[]>();
		map.put('1', new String[] { "" });
		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });
		map.put('*', new String[] { "*" });
		map.put('0', new String[] { " " });
		map.put('#', new String[] { "#" });
	}

	public List<String> letterCombinations(String digits) {
		// for each letter in the digits string
		List<String> ans = new ArrayList();
		if (digits.isEmpty())
			return ans;

		letterCombinations(digits, "", 0, ans);
		// recursively build the string
		return ans;
	}

	// call this recursively to generate all pairs of digits
	public void letterCombinations(String digits, String built, int pos, List<String> ans) {
		if (pos == digits.length()) {
			ans.add(built);
			return;
		}
		String[] letterList = map.get(digits.charAt(pos));
		if (letterList == null)
			return;
		for (String dig : letterList) {
			// built += dig; // <-- dont do this otherwise the string changes
			// its state
			letterCombinations(digits, built + dig, pos + 1, ans);
		}
	}

}
