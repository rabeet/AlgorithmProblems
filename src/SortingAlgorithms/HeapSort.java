package SortingAlgorithms;

import java.util.Arrays;

public class HeapSort {

	/*
	 * Time complexity: O(nlogn) - all cases 
	 * Space complexity: O(1)
	 */
	
	public static void main(String[] args) {
		int[] arr = {9,1,4,2,1};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/*
	 * 1. Construct MAXHEAP (O(n)) 
	 * 2. MAINTAIN MaxHeap: 
	 * 2a. Swap root with the last item and last item is in sorted position 
	 * 2b. Check whether it is a valid heap 
	 * 3. Keep doing 2 until the whole array is sorted
	 */
	public static void heapSort(int[] arr) {
		buildHeap(arr);
		int length = arr.length;
		
		while (length >= 1) {
			exchange(arr, length-1, 0);
			length--;
			maxHeapify(arr, 0, length);
		}
	}

	
	private static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void buildHeap(int[] arr) {
		int heapsize = arr.length;
		for (int i = heapsize / 2; i >= 0; i--) {
			maxHeapify(arr, i, heapsize);
		}
	}
	
	
	/*
	 * i = root node 
	 * 2i+1 = left child 
	 * 2i+2 = right child
	 */

	private static void maxHeapify(int[] arr, int i, int heapsize) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		// the index of the largest amongst the three nodes left, parent and child
		
		int largest = 0;
		if (l < heapsize && arr[l] > arr[i])
			largest = l;
		else
			largest = i;
		
		if (r < heapsize && arr[r] > arr[largest])
			largest = r;
		
		if (largest != i) {
			exchange(arr, i, largest);
//			maxHeapify(arr, largest, heapsize);
		}
	}
}
