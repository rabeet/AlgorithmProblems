package LeetCode;
import java.util.Arrays;

public class Prob453_MinimumMovesToeEqualArray {

	public static void main(String[] args) {
		System.out.println(minMovesTLE(new int[]{5,3,17,4}));
		System.out.println(minMoves(new int[]{5,3,17,4}));
	}
	
	
	/*
	 * [1,2,3]
	 * 3-1 = 2
	 * 2 + 1 = 3 moves
	 * 
	 * [2,2,10]
	 * 10-2 = 8
	 * 
	 * [2,5,10]
	 * [10,13,10]
	 * 8 + 3 = 11 moves
	 * 
	 * [7,2,0,7] = 7
	 * [14,9,7,7] = 7
	 * [14,16,14,14] = 2 == 16 moves
	 * [16,16,16,16]
	 * 
	 * [7,2,0,7] = 0
	 * [12,7,5,7] = 5
	 * [12,9,7,9] = 2
	 * [12,12,10,12] = 3
	 * [12,14,12,14] = 2
	 * [14,16,14,16] = 2
	 * [15,17,15,16] = 1
	 * [16,18,16,16] = 1
	 * [18,18,18,18] = 2
	 * 
	 * while (max != min)
	 * 	find max
	 * 	find min
	 *  add max-min to every element except max
	 *  count += max-min
	 *  end while
	 * return count  
	 * 
	 * 
	 */
	
	// [1,2,3]
	// [3,4,3]
	// min 3, max 4
	// 2 -> 3
	// return 3
	
	public static int minMoves(int[] nums) {
		Arrays.sort(nums);
		
		int min = nums[0];
		int sum = 0;
		for (int n : nums) sum += (n-min);
		return sum;
	}
	
	public static int minMovesTLE(int[] nums) {
		if (nums == null || nums.length < 2) return 0;
		
		int max = nums[nums.length-1], min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) max = nums[i];
			if (nums[i] < min) min = nums[i];
		}
//		System.out.println(max + " " + min);
		int sum = 0, s = 0;
		while (max != min) {
//			System.out.println(max +""+ min);
			s = max-min;
			min = max;
			sum += s;
			int tempmax = max;
			boolean added = false;
//			System.out.println(Arrays.toString(nums));
			for (int i = 0; i < nums.length; i++) {
				// skip one element
				if (nums[i] == tempmax && !added) {
					added = true;
					continue;
				}
				
				nums[i] += s;
				if (nums[i] >= max) max = nums[i];
			}
		}
		return sum;
	}

}
