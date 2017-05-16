public class Prob389_FindTheDifference {
	
	public static void main(String[] args) {
		System.out.println(findTheDifference("abs", "abLs"));
		System.out.println(findTheDifference("abs", "abLs"));
	}
	
	public static char findTheDifference(String s, String t) {
		if (s == null || t == null || t.length() < 1)
			return (char) -1;
		char c = t.charAt(t.length()-1);
		for (int i = 0; i < s.length(); i++) {
			c ^= s.charAt(i)^t.charAt(i);
		}
		return c;
	}
	
	public static char findTheDifferenceSum(String s, String t) {
		if (s == null || t == null || t.length() < 1)
			return (char) -1;
		int sum1 =0, sum2 = t.charAt(t.length()-1);
		for (int i = 0; i < s.length(); i++) {
			sum1 += s.charAt(i);
			sum2 += t.charAt(i);
		}
		return (char)(sum2-sum1);
	}

}
