
public class Prob7_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(Integer.MIN_VALUE));
	}
	
	public static int reverse(int x) {
        long output = 0;
        while (x != 0) {
            output = output*10+(x%10);
            if (output < Integer.MIN_VALUE || output > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return (int) output;
    }

}
