package LeetCode;

public class Prob161_OneEditDistance {

	
	/*
	 * ONE EDIT DISTANCE:
	 * if distance > 1 return false;
	 * get larger string and smaller string separate.
	 * diff = difference in length of both strings
	 * if small's length is 0 and large's length not 0 then return true;
	 * start pointer from both strings:
	 * 	if char not diff:
	 * 		if diff is 0: distance++
	 * 		if diff is 1: increase large pointer; distance++; break;
	 * 	else
	 * 		both pointers++
	 * 
	 * if diff is 1 that means that the last elemnt differs so increase edit.
	 * 
	 * return edit == 1
	 */
	
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false; // ensures a max edit distance of 1 b/w the 2 strings
        int edit = 0;
        String large = s.length() >= t.length() ? s : t;
        String small = t.length() <= s.length() ? t : s;
        if (small.length() == 0 && large.length() != 0) return true;
        int diff = large.length() - small.length();
        int small_i = 0, long_i = 0;
        while (long_i < large.length() && small_i < small.length()) {
            if (large.charAt(long_i) != small.charAt(small_i)) {
                if (diff == 0) {
                    edit++;
                } else {
                    edit++;
                    long_i++;
                    diff--;
                    continue;
                }
            }
            small_i++;
            long_i++;
        }
        if (diff == 1) edit++;
        return edit == 1;
    }
}
