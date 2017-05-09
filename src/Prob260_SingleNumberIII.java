import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Prob260_SingleNumberIII {

	public static void main(String args[]) {
		Prob260_SingleNumberIII prob = new Prob260_SingleNumberIII();
//		int[] ans = prob.singleNumber(new int[]{1,1,2,5,2,241});
		int[] ans = prob.singleNumberRabeet(new int[]{1,1,2,5,2,241});
		System.out.println(Arrays.toString(ans));
	}

	/*
	 * The problem with this one is that: How do I keep track of 2 different
	 * sums without mixing them up for eg: if I have: 1,1,3,2,2,4 then 3 has
	 * bits 011 and 4 has 101 but what if there is 5 instead of 4 i'll have 2 1s
	 * at least significant positions
	 */

	public int[] singleNumber(int nums[]) {
		int[] ans = new int[2];

		HashSet<Integer> hm = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.contains(nums[i])) {
				hm.remove(nums[i]);
			} else {
				hm.add(nums[i]);
			}
		}
		if (hm.size() > 1) {

			int count = 0;
			for (int n : hm) {
				ans[count++] = n;
			}
		}
		return ans;
	}
	
	/*
	 * 
	 * We need to go back to the xor and divide the arrays into 2 groups
	 * one with ith bit set and the other not set since the 2 numbers will differ at some point
	 * 
	 */
	
	public int[] singleNumberRabeet(int nums[]) {
		int[] ans = new int[2];
		
		int diff =0;
		
		for (int i = 0; i < nums.length; i++) {
			diff ^= nums[i];
		}
		System.out.println(diff);
		
		
		
		return ans;
	}

}