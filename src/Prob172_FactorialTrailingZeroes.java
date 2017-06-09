
public class Prob172_FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(40));
	}
	/*
	 * 
Prob 172 - Num of trailing zeroes:
given n return num of trailing zeroes in n!
eg: 4! -> 4x3x2 = 24
eg: 5! -> 5x24 = 120
eg: 6! -> 6x120 = 540
eg: 50! -> 10x20x30x40x50x5x15x25x35x45

10x9x8x7x6x5x4x3x2x1
15!

trailingZeroes(int n)
49%5 = 4 -> 49-4 = 45:
45/5 = 9

1 -> 1%5 = 4

5! 5%5 =0 5-0/5 = 1
10! 10-0/5 = 2
	 */
	// Keep dividing by 5 until it reaches zero...
	public static int trailingZeroes(int n) {
		return n == 0? 0 : n/5 + trailingZeroes(n/5);
	}

}
