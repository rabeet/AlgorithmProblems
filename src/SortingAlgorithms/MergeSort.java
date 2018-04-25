package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int test[] = {0,1,2,3,4,5,2,1,0,-14};
		System.out.println(Arrays.toString(test));
		sort(test);
		System.out.println(Arrays.toString(test));
	}
	
	/*
	 * MERGESORT:
	 *  1. Divide the arrays recursively into subarrays until they are of size 1.
	 *  2. Merge two subarrays one-by-one until the two subarrays form a sorted subarray
	 *  
	 *  TC: O(nlogn) best case
	 *  SC: O(n)
	 */
	
	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int mid = (low + high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}
	
	private static void merge(int[] arr, int low, int mid, int high) {
		int i = low, j = mid+1, k = low;
		int[] tempArr = new int[arr.length];
		for (int _i = 0; _i <= high; _i++) {
			tempArr[_i] = arr[_i];
		}
		while ((i <= mid) && (j <= high)) {
			if (tempArr[i] <= tempArr[j]) {
				arr[k] = tempArr[i];
				i++;
			} else {
				arr[k] = tempArr[j];
				j++;
			}
			k++;
		}
		// Copy the leftovers from the left
		while (i <= mid) {
			arr[k] = tempArr[i];
			i++;
			k++;
		}
		
		// Copy the leftovers from the right
		while(j <= high) {
			arr[k] = tempArr[j];
			j++;
			k++;
		}
	}

}
