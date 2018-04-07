package LeetCode;

public class Prob11_ContainerWithMostWater {
	
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int low = 0, hi = height.length-1;
        while (low < hi) {
            int width = hi-low;
            int length = Math.min(height[hi], height[low]);
            int area = width*length;
            max = area > max ? area : max;
            if (height[low] <= height[hi])
                low++;
            else hi--;
        }
        return max;
    }
    
    public int maxAreaTLE(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int length = Math.min(height[i], height[j]);
                int width = j-i; // 0 based
                int area = length*width;
                max = area > max ? area : max;
            }
        }
        return max;
    }
    
    // public boolean noObstacle(int[] arr, int start, int end) {
    //     for (int i = start+1; i < end; i++) {
    //         if (arr[start] <= arr[i] || arr[end] <= arr[i])
    //             return false;
    //     }
    //     return true;
    // }
}

/*

1 4 2 7 3
try to do memoization of some sort:
1 -> 1, area = 0, start = 1
1 -> 4, area = 3, start = 4
4 -> 2, area = 2, start = 4
4 -> 7, area = 6, start = 4

area 0 3
start 1 1
end 1 4
i 1 4
1,4,11,11,3


from i = 0 to end
    from j = i+1 to end
        if there is no obstacle in b/w
            calc area and see if it bigger than max area

no obstacle:
    if any number b/w the bounds is bigger than the bounds
*/