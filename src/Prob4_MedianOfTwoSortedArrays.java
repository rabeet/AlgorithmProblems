
public class Prob4_MedianOfTwoSortedArrays {
	
	public static void main (String args[]) {
		double median = findMedianSortedArrays(new int[] {1,7,8}, new int[]{2,4,5,6,10,11,19});
		System.out.println(median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if (nums1.length != 0 && nums2.length ==0) {
			int size = nums1.length;
			if (size %2 == 0) {
				return (nums1[size/2] + nums1[(size/2) -1])/2.0;
			} else {
				return (nums1[size/2]);
			}
		}
		
		if (nums1.length == 0 && nums2.length !=0) {
			int size = nums2.length;
			if (size %2 == 0) {
				return (nums2[size/2] + nums2[(size/2) -1])/2.0;
			} else {
				return (nums2[size/2]);
			}
		}
		
		boolean notFound = true;
		double median = 0;
		int start = 0, end = nums2.length-1;
		int target = nums1[(nums1.length)/2];
		int sizes = nums1.length + nums2.length;
		int mid = 0;
		
		while(notFound) {			
			if (start >= end) {
				if (sizes %2 == 0) {
					median = (target + nums2[mid])/2.0;
				}
				else {
					median = Math.min(target, nums2[mid]);
				}
				break;
			}
			
			mid = (start+end)/2;
			
			if (target > nums2[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return median;
	}
	
}
