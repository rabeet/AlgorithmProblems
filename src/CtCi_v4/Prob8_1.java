package CtCi_v4;
/**
 * 
 */

/**
 * @author Fatmi
 *
 */
public class Prob8_1 {

	/**
	 * 8.1: Generate nth fib number
	 * Recursive sol is very inefficient so use memoization
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(fib(20));
		System.out.println(fibMemoization(20));
	}
	
	public static int fibMemoization(int n) {
		if (n == 0 || n == 1) return n;
		
		int[] cache = new int[n+1];
		for (int i = 0; i < cache.length; i++) {
			if (i == 0 || i == 1) {
				cache[i] = i;
				continue;
			}
			cache[i] = cache[i-1]+cache[i-2];
		}
		
		return cache[n];
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) return n;
		return fib(n-1)+fib(n-2);
	}
}
