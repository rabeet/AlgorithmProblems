package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
	
	/* 
	 * choose a pivot from random
	 * subarray to the left is smaller, to the right is bigger
	 * run quicksort to the left and the right
	 * stop when whole array has been visited
	 * 
	 * TC: O(nlogn) best case
	 * SC: O(1)
	 */
	
	public static void main(String[] args) {

//		int test[] = {5,4,3,2,1,0,0,-1};
//		System.out.println(Arrays.toString(test));
//		quicksortRabeet(test, 0, test.length);
//		System.out.println(Arrays.toString(test));
		int[] test1 = {5,2,1,2,7,8,2,31};
		System.out.println(Arrays.toString(test1));
		quicksort(test1, 0, test1.length-1);
		System.out.println(Arrays.toString(test1));
		
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(arr, start, end);
//		System.out.println(pivot);
		quicksort(arr, start, pivot-1);
		quicksort(arr, pivot+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		Utilities.swap(arr, start, end);
		
		int i = start;
		for (int j = start; j < end; j++) {
			if (arr[j] <= arr[end]) {
				Utilities.swap(arr, i, j);
//				System.out.println(Arrays.toString(arr));
				i++;
			}
		}
//		System.out.println("stop");
		Utilities.swap(arr, i, end);
		return i;
	}
	
	public static void quicksortRabeet(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}
		int pivot = (start + end) / 2;
		int pivotVal = arr[pivot];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i ==  pivot)
				continue;
			if (arr[i] > arr[pivot])
				right.add(arr[i]);
			else
				left.add(arr[i]);
		}
		int[] temparr = new int[arr.length];
		int index = 0;
		for (int i : left)
			arr[index++] = i;
		arr[index++] = pivotVal;
		for (int i : right)
			arr[index++] = i;
		

		quicksortRabeet(arr, start+1, pivot);
		quicksortRabeet(arr, pivot, end-1);
	}

}



/*
4/24/18 practice:::

call quicksort like this: quicksort(arr, 0, arr.length-1)

quicksort(arr, start, end):
return if start exceeds end
int pivot = partition(arr, start, end);
quicksort(arr, start, pivot-1)
quicksort(arr, pivot+1, end);


partition(arr, start, end):
choose pivot to be either random or mid.
traverse through the array with elements smaller to be in left and larger to be in right of pivot
return pivot
 */


class Practice4_18 {

	public static void main(String[] args) {
		int[] arr = {5,1,2,7,23,9,0};
		quicksort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}

	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end) return;
		int pivot = partition(arr, start, end);
		quicksort(arr, start, pivot-1);
		quicksort(arr, pivot+1, end);
	}

	public static int partition(int[] arr, int start, int end) {
		int pivotIndex = (start+end)/2;
		Utilities.swap(arr, pivotIndex, end);
		int i = start;
		for (int j = i; j < end; j++) {
			if (arr[j]<= arr[end]) {
				Utilities.swap(arr, i, j);
				i++;
			}
		}
		Utilities.swap(arr, i, end);
		return i;
	}

		/*
	 5, 9, 7, 4, 0
	 5, 9, 0, 4, 7
	 5, 7, 0, 4, 9
	 5, 4, 0, 7, 9

	 7,9,5,4,0

	 7,5,9,4,0
	 7,5,4,9,0
	 7,5,4,0,9
	 0,5,4,7,9

	 4,1,2,1,0
	 4,1,0,1,2
	 1,4,0,1,2
	 1,0,1,4,2
	 1,0,1,2,4

	 4,1,2,5,0
	 4,1,0,5,2
	 1,4,0,5,2
	 1,0,4,5,2

	 4,7,2,5,0
	 4,7,0,5,2
	 0,7,4,5,2
	 0,2,4,5,7


	 swap first with pivot
	 i = first + 1
	 j = first+1 to end
	 	if (arr[j] > arr[i])
	 		swap i and j
	 		i++
	swap i with first
	*/


}