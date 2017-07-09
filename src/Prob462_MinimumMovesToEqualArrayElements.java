import java.util.Arrays;

public class Prob462_MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves2(new int[]{1,2,3}));
	}
	
	public static int minMoves2(int[] nums) {
		if (nums == null || nums.length < 2) return 0;
		
		Arrays.sort(nums);
		
		int max = nums[nums.length-1];
		int minmoves = 0;
		for (int i = 0; i < nums.length-1; i++) {
			minmoves += max-nums[i];
		}
		
		return minmoves;
	}

}