package Other;

import java.util.HashSet;
import java.util.Set;

public class NumberNotPresent {

	public static void main(String[] args) {

		// GIVEN a list of non neg integers give the first non-neg integer that
		// doesnt occur in the array
		// O(n) TC and O(n) SC is put every int in a set and then loop again to see if a given index is present in the set if it is not then that is the ans
		
		// O(n) TC and O(1) SC is to first swap every element until it is in its index and then loop thru the array once more to find if an index is not equal to the num inside it 

		System.out.println(getDifferentNumber(new int[] { 0, 1, 2, 3 }));
		System.out.println(getDifferentNumber(new int[] { 3, 0, 1, 2, 8 }));
		System.out.println(getDifferentNumber(new int[] { 1, 2, 3 }));
		int m = Integer.MAX_VALUE;
		System.out.println(getDifferentNumber(new int[] { m }));
		System.out.println(getDifferentNumber(new int[] { 0, 4, 2, 1, 7, m }));

//		System.out.println(getDifferentNumber2(new int[] { 1, 2, 3 }));
//		System.out.println(getDifferentNumber2(new int[] { 0,2,5,1,8}));
		System.out.println(getDifferentNumber2(new int[] {4,0,3,8}));
	}

	static int getDifferentNumber(int[] arr) {
		// your code goes here
		Set<Integer> set = new HashSet();
		for (int i : arr)
			set.add(i);

		int max = Integer.MAX_VALUE;
		for (int i : set) {
			if (i != Integer.MAX_VALUE && !set.contains(i + 1)) {
				if (i + 1 < max)
					max = i + 1;
			}
		}
		return !set.contains(0) ? 0 : max;
	}

	static int getDifferentNumber2(int[] arr) {
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp = arr[i];
			while (temp < n && arr[temp] != temp)
				swap(i, temp, arr);
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] != i)
				return i;
		}
		return n;
	}

	static void swap(int in1, int in2, int[] arr) {
		int temp = arr[in1];
		arr[in1] = arr[in2];
		arr[in2] = temp;
	}

	// 0 1 2 3

	// set: 0 1 2 3
	// return 4;

	// 3 0 1 2 8
	//

}
