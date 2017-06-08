
public class Prob172_FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(40));
	}
	
	// Keep dividing by 5 until it reaches zero...
	public static int trailingZeroes(int n) {
		return n == 0? 0 : n/5 + trailingZeroes(n/5);
	}

}
