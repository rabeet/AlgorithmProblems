import java.util.Arrays;
import java.util.Scanner;

public class Prob345_ReverseVowelsOfAString {

	public static void main(String[] args) {
		Prob345_ReverseVowelsOfAString prog = new Prob345_ReverseVowelsOfAString();
		System.out.println(prog.reverseVowels("YOYEAfu"));
	}

	public String reverseVowels(String s) {
		if (s == null || s.length() < 2)
			return s;
		char[] c = s.toCharArray();
		int j = c.length-1;
		for (int i =0; i <j; i++) {
			if (isVowel(c[i])) {
				while (j > i) {
					if (isVowel(c[j])) {
						char temp = c[j];
						c[j] = c[i];
						c[i] = temp;
						j--;
						break;
					}
					j--;
				}
			}
		}
		return String.valueOf(c);
	}
	
	public boolean isVowel(char c) {
		return (""+c).matches("[aAeEiIoOuU]");
	}

}
