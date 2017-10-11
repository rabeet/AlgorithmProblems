package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob442_FindAllDuplicatesInAnArray {

	public static void main(String[] args) {

		// Given an array of integers, 1 <= a[i] <= n (n = size of array),
		// some elements appear twice and others appear once.
		// do it without extra space in O(1)?
		int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(arr));
		System.out.println(Arrays.toString(arr));
	}

	public static List<Integer> findDuplicates(int[] arr) {

		// can't do mod operation because of not knowing what elements being
		// repeated
		// can do abs value adjustment since we know that a[i] will be between 1
		// and size of arr

		// EG: [4,-3,-2,7,8,2,-3,-1] --> [2,3]
		/*
		 * for each element in arr: i index = abs(arr[i])-1 if arr[index] was
		 * -ve then this means that it had been accessed b4 so add it to the
		 * list otherwise make arr[index] -ve do another iteration to make
		 * everything +ve
		 */
		List<Integer> ans = new ArrayList();

		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (arr[index] < 0)
				ans.add(Math.abs(arr[i]));
			arr[index] = -arr[index];
		}

		for (int i = 0; i < arr.length; i++)
			arr[i] = Math.abs(arr[i]);

		return ans;
	}

}
