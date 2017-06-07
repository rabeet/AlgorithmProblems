
public class Prob198_HouseRobber {
	
	
	public static void main (String[] args) {
		System.out.println(rob(new int[]{}));
	}
	
	public static int rob(int[] nums) {
		if (nums == null) return -1;
		
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int prev, curr;
			
			if (i < 2)	prev = 0;
			else prev = dp[i-2];
			if (i < 1) curr = 0;
			else curr = dp[i-1];
			
			max = Math.max(prev+nums[i], curr);
			dp[i] = max;
		}
		return max;
	}
}
