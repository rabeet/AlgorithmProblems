package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob266_PalindromePermutation {

	public boolean canPermutePalindrome(String s) {
		if (s == null || s.isEmpty())
			return false;
		// O(n) way: if even # of letters: even of every char; otherwise even of
		// everything except 1
		// TC: O(n), SC: O(n); n being the total characters in a hash map
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		boolean seen = false;
		List<Integer> set = new ArrayList<Integer>(map.values());
		for (Integer val : set) {
			if (val % 2 == 0)
				continue; // if the value is even then it is ok
			else { // otherwise the value is not even then it should be an even
					// letter word
				if (seen)
					return false; // if one odd has been seen before then return
									// false
				else
					seen = true; // otherwise make seen to be true and continue;
				continue;
			}
		}
		return true;
	}
}
