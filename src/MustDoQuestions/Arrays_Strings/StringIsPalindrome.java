package MustDoQuestions.Arrays_Strings;

public class StringIsPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("LOL"));
		System.out.println(isPalindrome2("LOL"));
		System.out.println(isPalindrome3(new char[]{1,2,1}));
	}
	
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);
	}
	
	public static boolean isPalindrome2(String s) {
		
		for (int i = 0, j = s.length() -1; i < j; i++,j--) {
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		
		return true;
	}
	
	public static boolean isPalindrome3(char[] arr) {
		for (int i = 0, j = arr.length-1; i < j; i++,j--)
			if (arr[i] != arr[j]) return false;
		return true;
	}
	

}
