
public class Prob392_IsSubsequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("ad", "fasdfs"));
		
	}
	
	// s = "abc", t = "ahbgdc"
	/*
	 * i = 3, j = 6
	 * 
	 * 
	 * s = "axc", t = "bsxga"
	 * 
	 * 
	 */
	
	public static boolean isSubsequence (String s, String t) {
		
//		asserts != null && t != null && !s.isEmpty() && !t.isEmpty() && s.length() <= t.length();
		if (s == null || t == null || s.length() > t.length()) return false;
		
		int i = 0, j = 0;
		
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		if (i == s.length()) return true;
		else return false;
	}

}
