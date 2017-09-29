package LeetCode;
import java.util.HashMap;
import java.util.Map;

public class Prob205_IsomorphicString {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("baa", "das"));
	}

	// hashmap
	// key: character in s
	// value: character in t

	public static boolean isIsomorphic(String s, String t) {
		assert s != null && t != null;

		Map<Character, Character> map = new HashMap();
		Map<Character, Character> map2 = new HashMap();

		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);

			if (map.containsKey(sc)) {
				if (map.get(sc) != tc) return false;
			} else {
				map.put(sc, tc);
			}
			
			if (map2.containsKey(tc)) {
				if (map2.get(tc) != sc) return false;
			} else {
				map2.put(tc, sc);
			}
		}

		return true;
	}

}
