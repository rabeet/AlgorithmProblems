package LeetCode;

public class Prob151_ReverseWordsInAString {
	
	public static void main(String... args) {
		System.out.println(new Prob151_ReverseWordsInAString().reverseWords(" 1"));
	}
	
	public String reverseWords(String s) {
		if (s.length() < 1)
			return s;
		String[] tokens = s.split(" ");
		String ans = "";
		for (int i = tokens.length - 1; i >= 0; i--) {
			if (!tokens[i].isEmpty()) {
				if (i == tokens.length - 1) {
					ans += tokens[i];
				} else {
					ans += " " + tokens[i];
				}
			}
		}
		return ans;
	}

}
