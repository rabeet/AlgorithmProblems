public class Prob371_SumOfTwoIntegers {
	
	public static void main (String[] args) {
		System.out.println(getSum(7,5));
		System.out.println(getSumEasier(7,5));
	}
	
	// Doesn't work for negatives: Have to do more bit manipulations to handle negatives
	// Does not handle 0 and 1 for some reason as well
	public static int getSum(int n1, int n2) {
		String b = "";
		int carry = 0;
		for (int i =0; i <= 32; i++) {
			if (((n1 >> i) & 1) == 1 && ((n2 >> i) & 1) == 1) {
				if (carry == 1)
					b = "1" + b;
				else {
					b = "0" + b;
					carry = 1;
				}
			} else if (((n1 >> i) & 1) == 0 && ((n2 >> i) & 1) == 0) {
				if (carry == 1) {
					b = "1" + b;
					carry = 0;
				} else {
					b = "0" + b;
				}
			} else {
				if (carry == 1) {
					b = "0" + b;
					carry = 1;
				} else {
					b = "1" + b;
				}
			}
		}
		return Integer.parseInt(b, 2);
	}
	
	public static int getSumEasier(int a, int b) {
		return b == 0 ? a:getSumEasier(a^b, (a&b) << 1);
	}

}
