package CtCi_v4;

public class Prob5_3 {

	public static void main(String[] args) {
		Integer test = 31;
//		System.out.println(Integer.toBinaryString(test));
		System.out.println(Integer.toBinaryString(test));
		System.out.println(Integer.toBinaryString(14));
	}
	
	public static void printNext(int n) {
		String largest = n==Integer.MAX_VALUE ? "N/A":""+(n<<1);
		String smallest = n==Integer.MIN_VALUE ? "N/A":""+(n>>1);
		System.out.println("NEXT SMALLEST: " + smallest);
		System.out.println("NEXT LARGEST: " + largest);
	}

}