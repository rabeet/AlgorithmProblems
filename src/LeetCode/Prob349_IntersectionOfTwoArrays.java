package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Prob349_IntersectionOfTwoArrays {
	
	public static void main(String args[]) {
		System.out.println(Arrays.toString(intersection(new int[]{1,2,1,3}, new int[]{66})));
	}
	
	public static int[] intersection(int[] n1, int[] n2) {
		if (n1.length < 1 || n2.length < 1 || n1 == null || n2 == null)
			return new int[0];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : n1)
			hm.put(i, 0);
		List<Integer> list = new ArrayList<Integer>();
		for (int i : n2) {
			if (hm.containsKey(i) && hm.get(i) == 0) {
				list.add(i);
				hm.put(i, 1);
			}
		}
		int[] ans = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

}
