import java.util.HashMap;
import java.util.Map;

public class Prob383_RansomNote {
	
	public static void main(String[] args) {
		System.out.println(canConstruct("fasv", "afsfa"));
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || magazine == null)
			return false;
		Map<Character, Integer> map = new HashMap();
		char[] magArr = magazine.toCharArray();
		for (char c : magArr)
			map.put(c, map.getOrDefault(c, 0)+1);
		char[] ransomArr = ransomNote.toCharArray();
		for (char c : ransomArr) {
			int occ = map.getOrDefault(c, -1);
			if (occ < 1)
				return false;
			else
				map.put(c, map.get(c)-1);
		}
		return true;
	}

}
