package LeetCode;

public class Prob81_SearchInRotatedSortedArrayII {
	
	public static void main(String[] args) {
		
		
		// search a particular num in a rotated sorted array - CAN CONTAIN DUPES
		int[] arr1 = new int[]{4,4,5,6,7,0,1,2};
		System.out.println(search(arr1, 7));
		System.out.println(search(arr1, 1));
		System.out.println(search(arr1, 2));
		System.out.println(search(arr1, 4));
		System.out.println(search(arr1, 5));
		System.out.println(search(arr1, 6));
		int[] arr2 = new int[]{3,7,8,8,12,12,12,1};
		System.out.println(search(arr2,1));
		System.out.println(search(arr2,8));
		int[] arr3 = new int[]{1,1,2,3,4,5,6,7,7,9,9,9,9,9,9};
		System.out.println(search(arr3,2));
		System.out.println(search(arr3,1));
		System.out.println(search(arr3,7));
		System.out.println(search(arr3,9));
		int[] arr4 = new int[]{2,0,0,0,0,0,0,0};
		System.out.println(search(arr4,0));
		System.out.println(search(arr4,3));
		System.out.println(search(arr4,2));
		int[] arr5 = new int[]{1,2,3,4,5,6,7,0};
		System.out.println(search(arr5,2));
		int[] arr6 = new int[]{0,0,0,0,0,0,0,0,1,2,9,9,9,-1,0,0,0,0,0,0};
		System.out.println(search(arr6,1));
		System.out.println(search(arr6,-1));
		System.out.println(search(arr6,5));
		int[] arr7 = new int[]{1,3,1,1,1};
		System.out.println(search(arr7,3));
		int[] arr8 = new int[]{1,1,3,1};
		System.out.println(search(arr8,3));
		System.out.println(search(arr8,2));
		int[] arr9 = {3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3};
		System.out.println(search(arr9,2));
	}
	
	
	/*
	 * EG1: 4 4 5 6 7 0 1 2; 7
	 * EG2: 3 7 8 8 12 12 12 1; 1, 7
	 * EG3: 1 1 2 3 4 5 6 7 7 9 9 9 9 9 9; 2, 1, 7
	 * helper searcher: arr, start, end, target
	 * 	if start > end return -1;
	 * 	mid = get mid
	 * 	if mid is target then return mid
	 * 	if (left of mid is rotated)
	 * 		if target is less than the left element
	 * 			// target must be on the right side
	 * 		else
	 * 			is target greater than mid and less than or equal to the right
	 * 				// target must be on the right side
	 * 			else
	 * 				// target must be on the left side
	 *  else
	 *  	if target is less than the mid element
	 *  		if target is greater than or equal the left element
	 *  			// target is on left side
	 *  		else
	 *  			// target must be on the right side
	 *  	else
	 *  		if target greater than or equal to the right end?
	 *  			// target is on the right side of mid
	 *  		else
	 *  			// target must be on the left side
	 */
	public static boolean search(int[] arr, int target) {
		return search(arr, 0, arr.length-1, target) == -1? false : true;
	}
	
	
	// {4,4,5,6,7,0,1,2}, 1));
	
	// {1,3,1,1,1}; 3
	// 1 1 3 1
	
	/*
	 * [3,4,4,4,4,4,4,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,-10,-10,-10,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3]
2
	 */
	private static int search(int[] arr, int start, int end, int target) { 
		if (start > end) return -1;
		while (start <= end) {
			int mid = (start+end)/2;
//			System.out.println(arr[mid]);
			if (arr[mid] == target) return mid; // -6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3]
			if (arr[start] > arr[mid]) {
				if (target < arr[start]) {
					if (target > arr[mid])
						start = mid + 1;
					else
						end = mid-1;
				} else {
					if (target > arr[mid] && target <= arr[end]) {
						start = mid +1;
					} else {
						end = mid -1;
					}
				}
			} else {
				if (target < arr[mid]) {
					if (target >= arr[start])
						end = mid -1;
					else
						start = mid +1;
				} else {
					if (target >= arr[end]) {
						if (arr[end] == arr[mid] &&  arr[start] == arr[mid]) {
							int findl = search(arr, start, mid-1, target);
							int findr = search(arr, mid+1, end, target);
							return findl == -1 ? (findr == -1? -1 : findr) : findl;							
						} else {
						start = mid +1;
						}
					}
					else {
						if (target < arr[mid])
							end = mid -1;
						else
							start = mid+1;
					}
				}
			}
		}
		return -1;
	}

}
