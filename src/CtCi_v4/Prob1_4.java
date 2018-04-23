package CtCi_v4;
import java.util.Arrays;
import java.util.HashMap;

public class Prob1_4 {
	
	/*
	 * 1.4: Design algo to determine if 2 strings are anagrams or not
	 * classic HashTable problem:
	 * add each character for string 1 in a hash table with the value as the occurence
	 * next go through the second string checking if the char exists in HT.
	 * TS: O(n+m)
	 * SC: O(n)
	 */

	public static void main(String[] args) {
		System.out.println(isAnagram("wow ", "o ww"));
		System.out.println(isAnagramSort("wow ", "o ww"));
	}
	
	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0)+1);
		}
		for (int i = 0; i < s2.length(); i++) {
			int j = hm.getOrDefault(s2.charAt(i), -1);
			if (j <= 0) return false;
			else hm.put(s2.charAt(i), --j);
		}
		
		return true;
	}
	
	public static boolean isAnagramSort(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		return Arrays.equals(c1,c2);
	}

}
