package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
	
	/*
	 * Time complexity: O(n^2) - worst case
	 * Space complexity: O(1)
	 */

	public static void main(String[] args) {
		
		int[] arr = {31,0,1,5,2,5,13,7,-5,8};
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j> 0; j--) {
				if (arr[j-1] > arr[j]) {
					Utilities.swap(arr, j, j-1);
				}
			}
		}
	}
	
	
}


/*

i: 0 -> end
j: i-1 -> 0
k = j;
	if ([i] < [k]) {
		swap(i,k)
		k = j-1;
	}
		
EG: 5,6,1,12,3

*/