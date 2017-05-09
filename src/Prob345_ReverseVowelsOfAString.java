import java.util.Arrays;
import java.util.Scanner;

public class Prob345_ReverseVowelsOfAString {

	public static void main(String[] args) {
		Prob345_ReverseVowelsOfAString prog = new Prob345_ReverseVowelsOfAString();
		System.out.println(prog.reverseVowels("my name is rabeet"));
		System.out.println("print from seond:");
		System.out.println(prog.reverseVowels("  1"));
	}

	public String reverseVowels(String s) {
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
