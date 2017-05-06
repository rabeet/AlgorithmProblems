import java.util.HashMap;
import java.util.Map;

public class Prob3_LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbbbba"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		int maxcount = 0;
		int currenttrack = 0;
		
		char[] chars = s.toCharArray();
		for (int i =0; i < chars.length; i++) {
			char c = chars[i];
			if (hm.containsKey(c)) {
				currenttrack = i - hm.get(c);
				hm.put(c, i);
			} else {
				currenttrack++;
				hm.put(c,i);
			}
			if (currenttrack > maxcount)
				maxcount = currenttrack;
		}
		return maxcount;
	}

}
