package CtCi_v4;

public class Prob1_8 {
	
	/*
	 * 1.8:
	 * Assume two strings s1 and s2 are given. Figure out if
	 * s1 is a rotation of s2. Eg: water is a rotation of rwate
	 * using only one call to isSubstring method.
	 * 
	 * Basic HashMap question except it has to be thru rotation
	 * First find the start of the s2 in s1, then traverse thru both strings
	 * matching each letter one by one. If either of the chain breaks then return false
	 * else return true.
	 * But then the problem is that oww is not a rotation of wow when it should be.
	 *
	 * the bruteforce way is to keep rotating s1 and equate it to s2 in each try
	 * 
	 * Easier way is to concatenate s1 to itself and see if s2 is a
	 * substring of s1.
	 */

	public static void main(String[] args) {
		System.out.println(isRotation("police", "poliec"));
		System.out.println(isSubstringLocal("policei", "pice"));
		System.out.println(isRotationEasy("police", "licepo"));
	}
	
	public static boolean isRotation(String s1, String s2) {
//		if (!isSubstring()) return false;
		
		if (s2.length() < s1.length()) {
			return false;
		} else {
			// Assuming we have  helper func which rotates a string once
			for (int i = 0; i < s1.length(); i++) {
				s1 = rotateOnce(s1);
				if (s1.equals(s2)) return true;
			}
		}
		return false;
	}
	
	public static boolean isRotationEasy(String s1, String s2) {
		if (s1.length() != 0 && s1.length() != s2.length()) return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1,s2);
	}
	
	// Rotate a string once
	public static String rotateOnce(String s) {
		String ans = ""+s.charAt(s.length()-1);
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length()-1) continue;
			ans += ""+s.charAt(i);
		}
		return ans;
	}

	// return true if s2 is a substring of s1
	public static boolean isSubstring(String s1, String s2) {
		int ind = s1.indexOf(s2);
		System.out.println(ind);
		return (ind >= 0);
	}
	
	// own implementation of issubstring
	public static boolean isSubstringLocal(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				for (int j = 0; j < s2.length(); j++) {
					if ((i+j) < s1.length() && s1.charAt(i+j) != s2.charAt(j))
						return false;
				}
			}
		}
		return true;
	}
}
