package LeetCode;
import java.util.Arrays;

public class Prob283_MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] {0,0,1,0,0,2});
		moveZeroesEasier(new int[] {0,0,1});
		moveZeroesEvenEasier(new int[] {0,0,1,5,0,9});
	}

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				pos = i;
		}

		for (int i = 0; i < pos; i++) {
			if (nums[i] != 0)
				continue;
			int j = i, ti = i;
			while (j <= pos) {
				if (nums[j] != 0) {
					nums[ti] = nums[j];
					ti = j;
					nums[j] = 0;
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return;
	}
	
	public static void moveZeroesEasier(int[] nums) {
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[pos++] = nums[i];
		}
		while (pos < nums.length) {
			nums[pos] = 0;
			pos++;
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public static void moveZeroesEvenEasier(int[] nums) {
		for (int i = 0, pos =0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pos] ^= nums[i];
				nums[i] ^= nums[pos];
				nums[pos++] ^= nums[i];
			}
		}
//		System.out.println(Arrays.toString(nums));
	}
}
