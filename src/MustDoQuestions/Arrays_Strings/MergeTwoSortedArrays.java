package MustDoQuestions.Arrays_Strings;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	public static void main(String... args) {
		// merge arr1 and arr2 sorted arrays into arr 1
		int[] arr1 = {4,6,9,10,0,0,0,0}, arr2 = {1,2,3,6}, arr3 = {0,5,8,9};
		merge(arr1, arr2);
		System.out.println(Arrays.toString(arr1));
		// merge arr1 and arr2 sorted arrays into a new arr
		System.out.println(Arrays.toString(merge2(arr3,arr2)));
		
	}
	
	public static void merge(int[] arr1, int[] arr2) {
		int end_1 = arr1.length - arr2.length-1;
		int end_2 = arr2.length-1;
		int i = arr1.length-1;
		while (end_1 >= 0 && end_2 >= 0) {
			if (arr1[end_1] > arr2[end_2]) {
				arr1[i] = arr1[end_1];
				end_1--;
			} else {
				arr1[i] = arr2[end_2];
				end_2--;
			}
			i--;
		}
		while (end_1 >= 0) {
			arr1[i] = arr1[end_1];
			i--;
			end_1--;
		}
		while (end_2 >= 0) {
			arr1[i] = arr2[end_2];
			i--;
			end_2--;
		}
	}
	
	public static int[] merge2(int[] arr1, int[] arr2) {
		int i = 0;
		int i_1 = 0;
		int i_2 = 0;
		int[] arr = new int[arr1.length + arr2.length];
		while (i_1 < arr1.length && i_2 < arr2.length) {
			if (arr1[i_1] < arr2[i_2]) {
				arr[i] = arr1[i_1];
				i_1++;
			} else {
				arr[i] = arr2[i_2];
				i_2++;
			}
			i++;
		}
		
		while (i_1 < arr1.length) {
			arr[i] = arr1[i_1];
			i++;
			i_1++;
		}
		
		while (i_2 < arr2.length) {
			arr[i] = arr2[i_2];
			i++;
			i_2++;
		}
		return arr;
	}

}
