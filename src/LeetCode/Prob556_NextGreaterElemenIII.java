package LeetCode;

public class Prob556_NextGreaterElemenIII {
    public int nextGreaterElement(int n) {
        if (n < 12) return -1;
        char[] nums = (""+n).toCharArray();
        int pos = -1;
        for (int i = nums.length -1; i> 0; i--) {
            if (nums[i] > nums[i-1]) {
                pos = i-1; break;
            }
        }
        if (pos == -1) return pos;
        char max = nums[pos+1];
        int maxpos = pos+1;
        for (int i = nums.length-1; i >= pos+1; i--) {
            if (nums[i] > nums[pos]) {
                max = nums[i];
                maxpos = i;
                break;
            }
        }

        // swap
        max = nums[pos];
        nums[pos] = nums[maxpos];
        nums[maxpos] = max;

        // Arrays.sort(nums, pos+1, nums.length);


        for (int i = pos + 1, j = nums.length-1; i < j; i++, j--) {
            max = nums[i];
            nums[i] = nums[j];
            nums[j] = max;
        }

        long ans = new Long(new String(nums));

        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }
}

/*
112 -> 121
21 -> -1
1235 -> 1253
541312 -> 541321
5431 -> -1

8718721830 -> 8718728130
8723810 -> 8723018

8723 8750 -> 8725 8730


From lsd to msd:
    find peak point
    from peak point onwards: find the smallest number bigger than number at peak point and swap
    sort from peak point onwards

23498751
23598741
23518749
23514789

23598764


1222 2333 -> 1222 3233 -> 1222 3233

*/