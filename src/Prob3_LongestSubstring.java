import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob3_LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbbbba"));
		System.out.println(longestSubstring("abbbbba"));
	}
	
	public static int longestSubstring(String s) {
		int i =0, j =0, max = 0;
        Set<Character> set = new HashSet<Character>();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (set.add(c)) {
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }        
        return max;
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
