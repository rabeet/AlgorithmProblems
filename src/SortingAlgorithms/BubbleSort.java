package SortingAlgorithms;

import java.util.Arrays;
public class BubbleSort {
	
	/* BUBBLESORT:
	 * Time complexity: O(n^2) - all cases
	 * Space complexity: O(1)
	 * 
	 * in a nested loop swap 2 adjacent elements if necessary
	 */

	public static void main(String[] args) {
		int test[] = {1,5,7,2,4,1};
		bubbleSort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					Utilities.swap(arr, j, j+1);
				}
			}
		}
	}

}
