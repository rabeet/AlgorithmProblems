package CtCi_v4;
import java.util.Arrays;

public class Prob1_1 {

	/*
	 * Question 1.1: Algo to determine if a string has uniques chars:
	 * 
	 * ASCII or utf-8 character sequences? Assuming Java way where chars are
	 * internally represented as integers. eg: a $ c -> unique eg: * F * -> not
	 * unique
	 * 
	 * easier way would be to use a HashSet and count the occurences. If we
	 * can't use any data DS.
	 * 
	 * Use 2 pointers or moore's voting algorithm.
	 * 
	 * count = 0; current char = word[0] for each element i : 1 -> end: is i the
	 * current char? yes: break; no: current char = i
	 * 
	 * 
	 * eg: a $ c eg: a l s a r g T count = 1 current char = word[0] for each
	 * element i : 1 -> end: i == current char? yes: count++; no count--; count
	 * == -1? current char = i; end for if count > -1 return false else return
	 * true
	 * 
	 * First sort it since chars are internally represented as ints. Then do a
	 * single pass to see if there are any dupes.
	 * 
	 * T: O(n log n) + O(n) = O(n) S: O(1)
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(isUnique("a&bcd*&FLPO"));
	}
	
	public static boolean isUnique(String word) {
		
		if (word == null) return false;
		if (word.length() < 2) return true;
		
		char[] chars  = word.toCharArray();
		Arrays.sort(chars);
		
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i-1])
				return false;
		}
		return true;
	}

}
