package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int test[] = {1,5,7,2,4,51,1};
		selectionSort(test);
		System.out.println(Arrays.toString(test));
	}
	
	/*
	 * Time complexity: O(n^2) - worst case
	 * Space complexity: O(1)
	 */
	
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min_index = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[min_index] > arr[j])
					min_index = j;
			}
			if (min_index != i) 
				Utilities.swap(arr, i, min_index);
//			System.out.println(Arrays.toString(arr));
		}
	}
}

/*
5,1,27,13,1

1,5,27,13,1
1,1,5,27,13

*/