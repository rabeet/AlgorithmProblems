package MustDoQuestions.Arrays_Strings;

public class BinarySearchInASortedRotatedArray {
	
	public static void main(String args[]) {
		// given in array that is rotated around some point, find a target
		int[] arr = {4,5,6,1,3};
		int[] arr1 = {8,9,10,1};
		int[] arr2 = {4,5,6,7,0,1,2};
		int[] arr3 = {4,5};
		int[] arr4 = {4};
		int[] arr5 = {5,1,2,3,4};
		int[] arr6 = {5,1,3};
		int[] arr7 = {5,5,5,5,5,5,5,5,4};
		
		System.out.println(binarySearchRotated(arr, 1));
		System.out.println(binarySearchRotated(arr1, 10));
		System.out.println(binarySearchRotated(arr2, 0));
		System.out.println(binarySearchRotated(arr3, 5));
		System.out.println(binarySearchRotated(arr4, 4));
		System.out.println(binarySearchRotated(arr5, 1));
		System.out.println(binarySearchRotated(arr6, 5));
		System.out.println(binarySearchRotated(arr7, 4));
		
		// 5 1 3
	}
	
	public static int binarySearchRotated(int[] arr, int target) {
		/*
		 * is mid element the ans? 
		 * YES: return mid element
		 * NO:  is the array rotated to the right of mid?
		 * 	 YES: is target in the range of left and mid (mid exclusive)?
		 * 			YES:end = mid-1
		 * 			NO :start = mid+1
		 * 	 NO : is the target bigger than the mid?
		 * 		YES: is the target less than or equal to left?
		 * 				YES: end = mid-1
		 * 				NO: start = mid+1
		 * 		NO: is the target greater than or equal to the left?
		 * 				YES: end = mid - 1
		 * 				NO:  start = mid + 1
		 */
		int start = 0, end = arr.length-1;
		while (start <= end) {
			int mid = (start+end)/2;
			if (arr[mid] == target) return mid;
			if (arr[start] <= arr[mid]) { // rotated to the right
				if (arr[start] <= target && target < arr[mid]) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			} else { // rotated to the left
				if (target > arr[mid]) {
					if (arr[start] <= target) 
						end = mid-1;
					else
						start = mid+1;
				} else {
					if (arr[start] >= target)
						end = mid-1;
					else
						start = mid+1;
				}
			}
		}
		return -1;
	}
	
}
