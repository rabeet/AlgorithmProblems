package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob119_PascalsTriangleII {
	
	public static void main(String[] args) {
		System.out.println(getRow(3));
		System.out.println(pascalsTriangle(3));
	}

	// NOT WORKING, dont know when was this..?
	public static List<Integer> pascalsTriangle(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int[] triangle = new int[n];
		triangle[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < i; j++) {
				triangle[j] += triangle[j]+triangle[j-1];
			}
		}
		for(int i = 0; i < triangle.length; i++)
			list.add(triangle[i]);
		return list;
	}

	public static List<Integer> getRow(int rowIndex) {
		int[] arr = new int[rowIndex+1];
		int n = arr.length;
		arr[0] = 1;
		for (int i = 0; i < rowIndex; i++) {
			for (int j = n-1; j>= 1; j--) {
				arr[j] += arr[j-1];
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++)
			list.add(arr[i]);
		return list;
	}
}
