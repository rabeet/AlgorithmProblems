package LeetCode;

import java.util.Stack;

public class Prob394_DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeStringOLD("2[ab]cd"));
	}
	
	public static String decodeString(String s) {
		return "";
	}
	
	public static String decodeString(String s, int times){
		return s;
	}
	
	// not working :S
	public static String decodeStringOLD(String s) {
        if (s.isEmpty()) return s;
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if (s.charAt(i) == ']') {
                int from = stack.pop();
                int times = ((int)s.charAt(from))-1;
                int t = 0;
                // build string
                String b = s.substring(from + 1, i);
                while (t < times) {
                    ans.append(b);
                    t++;
                }
            } else if (Character.isLetter(s.charAt(i)) && stack.isEmpty()) {
                ans.append(s.charAt(i));
            } else {
            	continue;
            }
        }
        return ans.toString().trim();
    }
}
