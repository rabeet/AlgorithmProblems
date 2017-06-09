import java.util.ArrayList;
import java.util.List;

public class Prob119_PascalsTriangleII {
	
	public static void main(String[] args) {
		
	}
	
	public static List<Integer> pascalsTriangle(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int[] triangle = new int[n];
		triangle[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < i; j++) {
				triangle[j] += triangle[j]+triangle[j-1];
			}
		}
		return list;
	}
}
