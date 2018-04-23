package Other.CommerceHub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnsiteStringBreak {
	
	public static void main(String[] args) {
		System.out.println(fitWords("hi bye hello", 5));
		System.out.println(fitWords("hi bye hello", 2));
		System.out.println(fitWords("hi bye hello", 6));
	}
	
 	public static List<String> fitWords(String sentence, int max) {
		List<String> ans = new ArrayList<String>();
		String[] words = sentence.split(" ");
		String built_word = "";
		for (String word : words) {
			String temp = built_word+word;
			if (temp.length() <= max) {
				built_word = temp+ " ";
			} else {
				if (built_word.trim().length() <= max) ans.add(built_word.trim());
				built_word = word + " ";
			}
		}
		String temp = built_word.trim();
		if(temp.length() <= max) ans.add(temp);
		return ans;
	}
	
}