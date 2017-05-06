import java.util.HashMap;
import java.util.HashSet;

public class Prob136_SingleNumber {
	
	public static void main (String args[]) {
		System.out.println(singleNumber(new int[] {3,3,7,7,2,8,9,8,9}));
	}
	
	public static int singleNumberOld(int[] nums) {
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (hs.contains(nums[i]))
				hs.remove(nums[i]);
			else
				hs.add(nums[i]);
		}
		return hs.size() != 0 ? hs.iterator().next() : 0;
	}
	
	/*
	 * bitwise xor
	 * 0 xor N = N
	 * N xor N = 0
	 * 
	 * N xor N xor M xor M xor P = 0 xor 0 xor P = P
	 * 
	 */
	
	public static int singleNumber(int[] nums) {
		
		for (int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		
		return nums[0];
	}
	
}
