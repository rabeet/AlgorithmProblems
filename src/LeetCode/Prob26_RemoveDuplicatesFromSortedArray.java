package LeetCode;
import java.util.Arrays;

public class Prob26_RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {1}));
	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length == 0)
			return 0;
		int ci = nums[0], last_pos = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != ci) {
				nums[last_pos++] = nums[i];
				ci = nums[i];
			}
		}
		return last_pos;
	}

}
