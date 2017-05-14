
public class Prob357_CountNumbersWithUniqueDigits {
	
	public static void main (String[] args) {
		System.out.println(countNumbersWithUniqueDigits(10));
	}
	
	public static int countNumbersWithUniqueDigits(int n) {
		int dp[] = new int[n+1];
		dp[1] = 10;
		dp[2] = 81;
		int sum = 91;
		for (int i = 3, pow = 8; i <= n; i++, pow--) {
			dp[i] = (int) (dp[i-1]*pow);
			sum += dp[i];
		}
		
		return sum;
	}

}
