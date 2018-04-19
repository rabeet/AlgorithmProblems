package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class Prob32_LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(())()()()"));

	}
	/*
	 * )()()) 4
	 * push 1
	 * pop 1
	 * 1->2
	 * push 3
	 * at 4 pop 3
	 * 1->4
	 * 
	 * (()
	 * push 0
	 * push 1
	 * pop 1
	 * 1->2
	 * 
	 */
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();

		// popl map
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				indexStack.push(i);
			} else {
				if (indexStack.isEmpty())
					continue;
				int startIndex = indexStack.pop();
				map.put(startIndex, i);
			}
		}
		
		for (int key : map.keySet()) {
			int val = map.get(key);
			while (map.containsKey(val + 1)) {
				map.put(key, map.get(val + 1));
				val = map.get(key);
			}
		}
		
//		for (Entry<Integer, Integer> e : map.entrySet()) {
//			int val = e.getValue();
//			while (map.containsKey(val + 1)) {
//				map.put(e.getKey(), map.get(val + 1));
//				val = map.get(e.getKey());
//			}
//		}

		return map.entrySet().stream().map(e -> e.getValue() - e.getKey() + 1).max(Integer::compare).orElse(0);
	}

}
