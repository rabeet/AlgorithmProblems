import java.util.Arrays;

public class Prob338_CountingBits {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(5)));
	}
	
	public static int[] countBits (int n) {
		int offset = 1;
		int[] zeroes = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				zeroes[i] = i;
				continue;
			}
			if (offset*2 == i)
				offset *= 2;
			zeroes[i] = zeroes[i-offset] + 1;
		}
		return zeroes;
	}
	
}
