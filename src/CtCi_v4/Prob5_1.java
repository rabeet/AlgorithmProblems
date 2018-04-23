package CtCi_v4;

public class Prob5_1 {

	/*
	 * 5.1: Copy bits from n1 to n2 from i to j
	 * 
	 * at most O(32) + O(32)
	 * 
	 * n1: 110000101
	 * n2: 000000110
	 * 
	 * i: 5, j: 7
	 * k: 0, l: 2
	 * 
	 * repeat until i reaches j
	 * 	temp = isolated kth bit of n2
	 * 	isolated ith bit of n1 = temp
	 * 	move back n1 to its default position
	 * 	k++;
	 * 
	 */
	
	public static void main(String[] args) {
		int n = 0b001;
		int m = 0b011;
		int ans = setBits(n,m,5,5);
		System.out.println(Integer.toBinaryString(ans));
	}
	
	public static int setBits(int n, int m, int i, int j) {
		if (i > j || i > 31 || j > 31) return n;
		if (m == 0) return n;
//		TODO: Look at better implementation
		int k = 0;
		while (i <= j) {
			int temp = (m >> k) & 1;
			int temp1 = n;
			n = temp;
			n = (n << i) | temp1;
			
			i++;
			k++;
		}
		return n;
	}
	
	/*
	 * TESTING:
	 * 0,0,0,0
	 * 0,1,0,0: 1 is returned as expected
	 * 0,5,10,5: 0 is returned as expected
	 * 1,3,1,2:
	 * 	0001
	 * 	0011
	 * 	
	 * n = 0111 as expected
	 * 
	 * 1,3,7,9
	 * 
	 * 
	 */

}
