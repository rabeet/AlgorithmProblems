package LeetCode;
public class Prob70_ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(0));
	}

	// SLow as it is recursive
	public static int climbStairs(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	// Fast as it is DP
	public static int climbStairsDP(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

}
