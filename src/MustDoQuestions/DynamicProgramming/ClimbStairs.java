package MustDoQuestions.DynamicProgramming;

public class ClimbStairs {

	public static void main(String[] args) {
		// given you can climb 1,2 or x stairs in one step, how many ways of reaching the top?
		System.out.println(climb(4,4));
	}
	
	/*
	 * if step is or stairs is 1 then there is only 1 way to get to the top
	 * otherwise it is the sum of the last 'step' values in cache
	 * for eg: for stairs = 3 and step= 2 the ans is cache[1]+cache[2] which is 3
	 * BOTTOM UP sol:
	 * 
	 * TOPDOWN will involve making recurive calls and in each call
	 * reducing the stairs by 1 until the base case is reached which will 
	 * be 0, 1 or 2.
	 */
	public static int climb(int stairs, int step) {
		int[] cache = new int[stairs+2];
		cache[0] = 1;
		cache[1] = 1;
		// can do sliding window here!
		for (int i = 2; i <= stairs; i++) {
			int sum = 0;
			for (int j = step; j > 0; j--)
				sum += i-j < 0 ? 0 : cache[i-j];
			cache[i] = sum;
		}
		return cache[stairs];
	}

}
