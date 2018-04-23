package CtCi_v4;

public class Prob5_5 {

	public static void main(String[] args) {
		System.out.println(bitsRequired(-14,-1245));
		System.out.println(bitsRequiredXOR(14,-1245)); // <-- fails with -ve num tho
	}
	
	public static int bitsRequired(int from, int to) {
		int output = 0;
		for (int i = 0; i< 32; i++) {
			if (((from >> i)&1) != ((to >> i)&1)) output++;
		}
		return output;
	}
	
	public static int bitsRequiredXOR(int from, int to) {
		int output = 0;
		for (int i = from^to; i != 0; i >>= 1) {
//			if ((i&1) == 1) output++; // can do this or:
			output += (i&1);
		}
		return output;
	}
}
