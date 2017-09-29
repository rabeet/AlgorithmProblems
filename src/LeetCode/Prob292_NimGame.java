package LeetCode;
public class Prob292_NimGame {
	
	public static void main(String[] args) {
		System.out.println(canWinNim(8));
	}
	
	public static boolean canWinNim (int n) {
		return (n%4 != 0);
	}

}
