
public class Prob125_ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindromeWord("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("5A man, a plan, a canal: Panama5"));
	}
	
	public static boolean isPalindrome(String s) {
		if (s.isEmpty() || s == null)
			return true;
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z*0-9]", "");
		System.out.println(s);
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
	public static boolean isPalindromeWord(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString() == s;
	}
}
