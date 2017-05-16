import java.util.HashMap;
import java.util.Map;

public class Prob13_RomanToInteger {
	
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCVI"));
	}
	
	public static int romanToInt(String s) {
		if (s.length() < 1 || s == null)
			return 0;
//		if (!s.matches("[I|V|X|L|C|D|M]+"))
//			return 0;
		
//		Map<Character, Integer> map = new HashMap();
//		map.put('I', 1);
//		map.put('V', 5);
//		map.put('X', 10);
//		map.put('L', 50);
//		map.put('C', 100);
//		map.put('D', 500);
//		map.put('M', 1000);
		
		int map[] = new int['Y'-'C'];
		map['I'-'C'] = 1;
		map['V'-'C'] = 5;
		map['X'-'C'] = 10;
		map['L'-'C'] = 50;
		map['C'-'C'] = 100;
		map['D'-'C'] = 500;
		map['M'-'C'] = 1000;
		
		char[] chars = s.toCharArray();
		int sum = 0;
		for (int i = chars.length-1; i >= 0; i--) {
			if (i != chars.length-1 && map[chars[i]-'C'] < map[chars[i+1]-'C']) {
				sum -= map[chars[i]-'C'];
			} else {
				sum += map[chars[i]-'C'];
			}
		}
		
		return sum;
	}

}
