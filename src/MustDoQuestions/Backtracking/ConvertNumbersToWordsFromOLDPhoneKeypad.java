package MustDoQuestions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ConvertNumbersToWordsFromOLDPhoneKeypad {
	
	static String[] map;
	
	static {
		map = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	}

	public static void main(String[] args) {
		// given a string representing key presses in an old phone convert them to all possible words
		System.out.println(letterCombinations("1982"));
	}
	
	static public List<String> letterCombinations(String digits) {
		// for each letter in the digits string
		List<String> ans = new ArrayList();
		if (digits.isEmpty())
			return ans;

		letterCombinations(digits, "", 0, ans);
		// recursively build the string
		return ans;
	}

	// call this recursively to generate all pairs of digits
	static public void letterCombinations(String digits, String built, int pos, List<String> ans) {
		if (pos == digits.length()) {
			ans.add(built);
			return;
		}
		int num = Integer.parseInt(""+digits.charAt(pos));
		String letterList = map[num-1];
		if (letterList == null)
			return;
		if (letterList.isEmpty())
			letterCombinations(digits, built,pos +1, ans);
		for (int i = 0; i < letterList.length(); i++) {
			// built += dig; // <-- dont do this otherwise the string changes
			// its state
			letterCombinations(digits, built + letterList.charAt(i), pos + 1, ans);
		}
	}

}
