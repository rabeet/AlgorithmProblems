package LeetCode;
import java.util.Arrays;
import java.util.HashMap;

public class Prob169_MajorityElement {
	
	public static void main(String... args) {
		Prob169_MajorityElement prob = new Prob169_MajorityElement();
		System.out.println((prob.majorityElementVoting(new int[]{1,13,1,13,2,5,7,7,7,11,13,13})));
	}
	
	public int majorityElement(int[] nums) {
		int ans = -1;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		if (nums == null)
			return ans;
		for (int i : nums) {
			if (hm.containsKey(i)) {
				int occ = hm.get(i) + 1;
				hm.put(i, occ);
			} else {
				hm.put(i, 1);
			}
			
			if (hm.get(i) > (nums.length/2)) {
				ans = i;
				break;
			}
		}
		return ans;
	}
	
	public int majorityElementVoting(int[] nums) {
		int count = 1, major = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
				count++;
			}
			else {
				if (nums[i] == major)
					count++;
				else
					count--;
			}
		}
		System.out.println(count);
		return major;
	}
}
