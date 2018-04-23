package CtCi_v4;
import java.util.Arrays;

public class Prob1_2 {

	/*
	 * 1.2: Reverse C-Style string: What is C-style string? "abcd&" <-- "&" is
	 * assumed to be the null char
	 * 
	 * charset? ASCII or utf-8? "abab&" -> "baba&"?
	 * 
	 * char[] words = {'a', 'b', 'o', 'X', '&'} 
	 * check null 
	 * for (int i = 0, int j = words.length-2; i < j; i++, j--) 
	 * { char tmp = words[i]; words[i] = words[j]; words[j] = tmp; } 
	 * return words;
	 * i = 0; j = 3; while i < j; i++; j-- words = Xboa&
	 * 
	 * i = 1; j = 2; i < j words = Xoba&
	 * 
	 * i = 2; j = 1; i !< j terminate
	 * 
	 * words = Xoba&
	 * 
	 * words = av&
	 * 
	 * words = a&
	 * 
	 * words = null?
	 * 
	 */

	public static void main(String[] args) {
		char[] arr = {'a','f',']','*','&'};
		System.out.println(Arrays.toString(arr));
		reverseCString(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverseCString(char[] words) {
		if (words == null) return;
		if (words.length < 3) return;
		
		for (int i = 0, j = words.length-2; i < j; i++, j--) {
			char tmp = words[i];
			words[i] = words[j];
			words[j] = tmp;
		}
	}
}
