package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob350_IntersectionOfTwoArraysII {
	
	public static void main(String args[]) {
		System.out.println(Arrays.toString(intersection(new int[]{0,0,1,4,2,4,4,4,56,1,1,1,2,2,2,2,6,6,9}, new int[]{1,1,1,1,2,5,5,6,1,315})));
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) 
			return new int[0];
		boolean smaller = nums1.length < nums2.length;
		boolean sorted = false;
		Map<Integer, Integer> hm = new HashMap();
		int[] n1 = nums1, n2 = nums2;
		if (!smaller) {
			n1 = nums2;
			n2 = nums1;
		}
		for (int i : n1) {
			if (sorted) {
				if (i >= n2[0])
					hm.put(i, hm.getOrDefault(i, 0)+1);
			} else {
				hm.put(i, hm.getOrDefault(i, 0)+1);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i : n2) {
			if (hm.containsKey(i) && hm.get(i) > 0 ) {
				list.add(i);
				hm.put(i, hm.get(i)-1);
			}
		}
		int[] ans = new int[list.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

}
