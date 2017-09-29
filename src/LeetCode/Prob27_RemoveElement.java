package LeetCode;
import java.util.Arrays;

public class Prob27_RemoveElement {

	public static void main(String[] args) {
		System.out.println(removeElement(new int[]{1,2,7,5,1,2,7,2}, 2));
	}
	
	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) return 0;
		int last_pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) nums[last_pos++] = nums[i];
		}
		return last_pos;
	}

}
