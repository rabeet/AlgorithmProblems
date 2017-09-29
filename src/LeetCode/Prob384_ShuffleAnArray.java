package LeetCode;
import java.util.Arrays;
import java.util.Random;

public class Prob384_ShuffleAnArray {
	
	public static void main(String[] args) {
		Prob384_ShuffleAnArray prob = new Prob384_ShuffleAnArray();
		Solution obj = prob.initSol();
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.reset()));
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.reset()));
		System.out.println(Arrays.toString(obj.shuffle()));
		System.out.println(Arrays.toString(obj.reset()));
	}
	
	public Solution initSol() {
		Solution obj = new Solution(new int[]{});
		return obj;
	}
	
	class Solution {
		int[] nums;
		int[] backup;
		public Solution (int nums[]) {
			this.nums = nums;
			backup = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				backup[i] = nums[i];
			}
		}
		public int[] shuffle() {
			Random random = new Random();
			for (int i = 0; i < nums.length; i++) {
				int temp = nums[i];
				int rand = random.nextInt(nums.length);
				nums[i] = nums[rand];
				nums[rand] = temp;
				
			}
			return nums;
		}
		
		public int[] reset() {
			for (int i = 0; i < backup.length; i++) {
				nums[i] = backup[i];
			}
			return nums;
		}
	}
}
