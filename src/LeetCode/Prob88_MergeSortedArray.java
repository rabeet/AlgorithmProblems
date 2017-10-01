package LeetCode;

public class Prob88_MergeSortedArray {
public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (nums1 == null || nums2 == null) return;
        // do this backwards
        // 3 pointer approach: pointer 1 is pointing to the end of nums1, pointer 2 is pointing to the end of nums2
        // pointer 3 is pointing to the (blank) end of nums1
        int p1 = m-1, p2 = n-1, i = nums1.length-1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
        while (p1 >= 0) {
            nums1[i] = nums1[p1];
            i--;
            p1--;
        }
        while (p2 >= 0) {
            nums1[i] = nums2[p2];
            i--;
            p2--;
        }
        
        // 1, 2, 3, 5, 8, 9, 10, 15, == 1, 2, 3, 5, 8, 8, 10, 15
        // 3
        
        // 1, 9, 10, 11 == 0 0 0 0 1 9 10 11 15
        // 0, 0, 0, 0, 15
        
        // 1 2 = 1 2
        // []
        
        // [] = []
        // []
    }
}
