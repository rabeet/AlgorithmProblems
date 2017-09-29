package LeetCode;
import java.util.HashMap;

public class Prob137_SingleNumberII {
	
	public static void main(String... args) {
		System.out.println(new Prob137_SingleNumberII().singleNumber(new int[] {1,1,1,2,2,2,3}));
		System.out.println(new Prob137_SingleNumberII().singleNumberNoHM(new int[] {1,1,1,2,2,2,3}));
		System.out.println(new Prob137_SingleNumberII().singleNumberRabeet(new int[] {1,2,2,2}));
	}
	
	public int singleNumber(int[] nums) {
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				int occurences = hm.get(nums[i]);
				if (occurences > 1)
					hm.remove(nums[i]);
				else {
					hm.remove(nums[i]);
					hm.put(nums[i], ++occurences);
				}
			} else {
				hm.put(nums[i], 1);
			}
		}
		return hm.isEmpty() ? 0 : hm.keySet().iterator().next();
	}
	
	/*
	 * 
	 * This is solvable if we think of integers as numbers of bits:
	 * 4: 100
	 * 3: 011
	 * 1: 001
	 * 
	 * if the array is: 1,4,4,4,3,3,3 then its something like this:
	 * 001, 100, 100, 100, 011, 011, 011
	 * 
	 * At each iteration we inspect the i'th bit for each number:
	 * 0th iteration: 1, 0, 0, 0 ,1, 1, 1
	 * 
	 * since we reset the sum by sum %= 3 by the end we should only have a single 1 or 0 at this position.
	 * 
	 * we see that in this iteration the unknown number's least significant bit is on so we turn it on in the answer by:
	 * ans = ans | sum << i;
	 */
	
	// Single number II without HashMap
	// https://discuss.leetcode.com/topic/43166/java-o-n-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
	public int singleNumberNoHM(int[] nums) {
		int ans = 0;
		
		for (int i = 0; i < 32; i++) { // for each bit
			int sum = 0;
			for (int j = 0; j < nums.length; j++) { // for each number in array
				if (((nums[j] >> i) & 1) == 1) {
					sum++;
					sum %= 3;
				}
			}
			if (sum == 1) {
				ans |= sum <<i;
			}
		}
		
		return ans;
	}
	
	public int singleNumberRabeet(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int c : nums) {
				if (((c >> i) & 1) == 1) {
					sum++;
					sum %= 3;
				}
			}
			if (sum != 0) {
				ans |= sum << i;
			}
		}
		return ans;
	}

}
