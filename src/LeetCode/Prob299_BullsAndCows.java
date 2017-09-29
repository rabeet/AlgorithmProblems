package LeetCode;
import java.util.HashMap;
import java.util.Map;

public class Prob299_BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("1132", "4123"));
	}
	
	// 2 pass for O(n)
	
	// 1st pass -> figure out all the bulls and replace the char with a * or something and populate a HM with key: char, val: occurences
	
	// 2nd pass -> figure out the cows counting the occurences of each char using the HM
	
	// Secret: "1132", guess: "4123"
	// expected output: "1A2B"
	// after 1st pass: A = 1, C = 2
	
	// output: "1A2B"
	
	
	public static String getHint (String secret, String guess) {
		
		assert secret != null && guess != null && secret.length() > 0 && guess.length() > 0 && guess.length() == secret.length();
		
		int bulls = 0;
		int cows = 0;
		
		char[] sec = secret.toCharArray();
		char[] gues = guess.toCharArray();
		Map<Character, Integer> map = new HashMap();
		
		// 1st pass:
		for (int i = 0; i < sec.length; i++) {
			if (sec[i] == gues[i]) {
				bulls++;
				sec[i] = '\0'; gues[i] = '\0';
			}
			else {
				map.put(sec[i], map.getOrDefault(sec[i], 0)+1);
			}
		}
		
		// 2nd pass:
		for (char c : gues) {
			int occ = map.getOrDefault(c, 0);
			if (occ > 0) {
				cows++;
				occ--;
				map.put(c, occ);
			}
		}
		
				
		return ""+bulls+"A"+cows+"B";
	}

}
