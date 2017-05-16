public class Prob387_FirstUniqueElement {
	
	public static void main(String[] args) {
		System.out.println(firstUniqueChar("ababbbaababas"));
	}
	
	public static int firstUniqueChar(String s) {
		int[] chars = new int[26];
		// First pass
		char[] arr = s.toCharArray();
		for (char c : arr) {
			chars[c - 'a']++; 
		}
		
		// Second pass
		for (int i = 0; i < arr.length; i++) {
			if (chars[arr[i] - 'a'] == 1)
				return i;
		}
		return -1;
	}

}
