package MustDoQuestions.Arrays_Strings;

import java.util.Arrays;

public class ReverseArrayInPlace {
	
	public static void main(String args[]) {
		int[] arr = {1}, arr2 = {1,2,3}, arr3 = {2,5}, arr4 = {1,2,8,2,1};
		reverse(arr);
		reverse(arr2);
		reverse(arr3);
		reverse(arr4);
		reverse(null);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
	}
	
	public static void reverse(int[] arr) {
		if (arr == null) return;
		
		for (int i = 0, j = arr.length-1; i<j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
}
