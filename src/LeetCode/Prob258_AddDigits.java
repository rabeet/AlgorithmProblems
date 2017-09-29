package LeetCode;

public class Prob258_AddDigits {
	
	public static void main (String[] args) {
		System.out.println(addDigits(292));
	}
	
	public static int addDigits(int num){
		 /**
		  * Using digital root
		  */
		return (num % 9) != 0 ? num %9 :0;
	}
	
	public static int addDigitsDigitalRoot(int num) {
		return num - 9* ((num-1)/9);
	}
}
