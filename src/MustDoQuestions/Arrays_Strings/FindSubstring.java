package MustDoQuestions.Arrays_Strings;

public class FindSubstring {

	public static void main(String[] args) {
		System.out.println(findSubstring("bostons","to"));
		System.out.println("apple".indexOf("g"));
	}
	
	public static int findSubstring(String s, String find) {
		if (s.isEmpty() && find.isEmpty()) return 0;
		if (s.isEmpty()) return -1;
		if (find.isEmpty()) return 0;
		
		int found = -1;
		for (int i = 0; i < s.length(); i++) {
			
			// find the first character of find
			if (s.charAt(i) == find.charAt(0))
				found = findIt(i, s, find); // <- find the rest of find
			
			if (found != -1) return found;
		}
		return -1;
	}
	
	private static int findIt(int i, String given, String find) {
		if (find.length() > given.length()-i) return -1; // if at the length of the finding substring is greater than the remaining chars on given
		int t = i;
		for (int j  = 0; j < find.length(); j++) {
			if (find.charAt(j) != given.charAt(i)) return -1;
			i++;
		}
		return t;
	}
}