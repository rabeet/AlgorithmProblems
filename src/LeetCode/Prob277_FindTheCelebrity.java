package LeetCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Prob277_FindTheCelebrity {

	public static void main(String args[]) {
//		System.out.println(findCeleb(3));
		System.out.println(findCeleb2(2));
	}
	
	public static int findCeleb2(int n) {
		// find a celeb by the relation of a >b > c > d and so on
		// if i does not know celeb then celeb cant be celebrity and i may be celebrity <-- NO
		// if celeb knows i then celeb cant be celebrity and i may be celebrity so update celeb = i
		int celeb = 0;
		for (int i = 1; i < n; i++) {
			if (knows(celeb, i))
				celeb = i;
		}
//		System.out.println(celeb);
		
		// Check if he really is celeb
		for (int i = 0; i < n; i++) {
			if (i == celeb)
				continue;
			if (knows(celeb, i) || !knows(i, celeb))
				return -1;
		}
		
		return celeb;
	}

	public static int findCeleb(int n) {
		for (int i = 0; i < n; i++) {
			boolean isCeleb = isCeleb(i, n);
			if (isCeleb)
				return i;
		}
		return -1;

	}

	public static boolean isCeleb(int index, int n) {
		for (int i = 0; i < n; i++) {
			if (i == index)
				continue;
			if (!knows(i, index) || knows(index, i))
				return false;
		}
		return true;
	}

	public static boolean knows(int n1, int n2) {
		return false;
	}
}
