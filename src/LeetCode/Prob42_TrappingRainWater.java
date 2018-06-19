package LeetCode;

public class Prob42_TrappingRainWater {
    public int trap(int[] arr) {
        if (arr.length == 0) return 0;
        int l = arr[0], r = arr[arr.length-1], i = 0, j = arr.length-1;
        int ans = 0;
        while ( i < j ) {
            if (arr[i] < arr[j]) {
                if (arr[i] >= l) {
                    l = arr[i];
                } else {
                    ans += l-arr[i];
                }
                i++;
            } else {
                if (arr[j] >= r) {
                    r = arr[j];
                } else {
                    ans += r-arr[j];
                }
                j--;
            }
        }
        return ans;
    }
}

/*
Keep 2 pointers on each side of array:
initialize l as arr[0] and r as arr[last]:
    while i < j:
        if arr[i] < l:
            ans+= l-arr[i];
        else:
            l = arr[i]

        if arr[j] < r:
            ans+= r-arr[j];
        else:
            r = arr[j]

*/
