package LeetCode;
import java.util.HashMap;

public class Prob171_ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		Prob171_ExcelSheetColumnNumber prob = new Prob171_ExcelSheetColumnNumber();
		System.out.println(prob.titleToNumber("AAA"));
	}

	public int titleToNumber(String s) {
		if (s.length() < 1 || s == null)
			return -1;
		char[] c = s.toCharArray();
		int pow = 0, ans = 0;
		
		for (int i = s.length()-1; i >= 0; i--) {
			int val = c[i] - 'A' + 1;
			ans += val * (Math.pow(26, pow++));
		}
		return ans;
	}
}
