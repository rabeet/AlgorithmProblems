
public class LongestPrefixSequentialOrder {

	// From LeetCode challenge
	public static void main(String[] args) {
		System.out.println(longestPrefix("abcdefgc"));
	}
	
	/*
	 * "knotty" = 6
	 * "excel" = 2
	 * "a" = 1
	 * "" & null -> exception
	 * "dab" = 1
	 * 
	 */
	
	
	public static int longestPrefix(String s) {
		assert s != null && s.length() > 0;
		
		char[] arr = s.toCharArray();
		int max = 0;
		int fast = 0, slow = fast;
		
		while (fast < arr.length) {
			if (slow == fast) {
				fast++;
				continue;
			}
			if (arr[fast] < arr[fast-1]) {
				break;
			}
			else {
				if (fast-slow > max) max = fast-slow;
			}
			fast++;
		}
		return ++max;
	}
}
