package Glassdoor;

//URL:https://www.glassdoor.com/Interview/Bloomberg-L-P-Software-Engineer-Interview-Questions-EI_IE3096.0,13_KO14,31_IP10.htm
//1. return the maximum product of 3 numbers in an array 2. print out the pairs of a number and the nearest greater number to its right in an array. Example: given [1,2,5,2,6], print out (1,2), (2,5), (5,6), (2,6) 10 Answers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Bloomberg_116 {

    public static void main(String[] args) {
        assert maxProduct(new int[]{1, 2, 3, 4, 5}) == 60;
        assert maxProduct(new int[]{1, 2, 3, -4, -5}) == 60;
        assert maxProduct(new int[]{9, 1, 5, 0, -2, -12, 7}) == 9 * 7 * 5;
        assert maxProduct(new int[]{0, 5, 2, 8, -13, 5, 7, -12}) == -12 * -13 * 8;
        assert maxProduct(new int[]{0, 5, 2, 8, 8, -13, 5, 7}) == 8 * 8 * 7;

        nextGreatestElement(new int[]{1,2,5,2,6}).stream().forEach(e -> System.out.println(Arrays.toString(e)));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length < 3) return 0;
		/*
		sort
		if both -ves and +ves: compare the 2 -ves with second and 3rd last +ve
		if all -ves get last 3 -ves
		if all +ves get last 3 +ves

		Without sort you keep 5 vars
		 */
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    // use a stack to keep the first num
    public static List<int[]> nextGreatestElement(int[] nums) {
        List<int[]> list = new ArrayList<>();
        if (nums.length == 0) return list;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i])
                list.add(new int[]{stack.pop(), nums[i]});
            stack.push(nums[i]);
        }
        return list;
    }
}