package LeetCode;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String args[]) {
		int a[] = {4, 4, 2, 1};
		int target = 3;
		
		System.out.println(Arrays.toString(TwoSum(a,target)));
	}

	public static int[] TwoSum(int[] a, int target) {

		int[] ans = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			hm.put(a[i], i);
		}

		for (int i = 0; i < a.length; i++) {
		int index = target-a[i];
			if (hm.containsKey(index)) {
				int val = hm.get(index);
				if (i != val) {
				ans[0] = i; ans[1] = hm.get(target-a[i]);
				break;
				}
			}
		}
		return ans;
	}
}