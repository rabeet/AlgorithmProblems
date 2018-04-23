package CtCi_v4;

public class Prob5_6 {
	
	/*
	 * 5.6: Program to swap odd and even bits in an int with as few instructions
	 * as possible
	 * 
	 * shift 1 to the left and xor the input with it
	 * 
	 * Eg:   000101110
	 * shift:001011100
	 * XOR:  110001010
	 * 
	 * its a freakin trick question....
	 * mask all odd bits with 1010101010 in binary then shift to the left
	 * then mask the num with 0101010101 in binary then shift to the right
	 * then OR them both.
	 */

	public static void main(String[] args) {
		System.out.println(moveBits(8));
		Integer sn = Integer.valueOf("0101010101010101010101010101010", 2);
		System.out.println(sn + " " + 0xAAAAAAAA);
		System.out.println(Integer.MIN_VALUE>>2);
	}
	
	public static int moveBits(int num) {
		return ((num & 0xAA) >>1) /* <-- set all odd bits */ 
				| // OR it to turn on all the bits
				((num & 0x55 )<< 1) /* <-- set all even bits */;
	}

}

