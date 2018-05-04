package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob120_Triangle {

    public static void main(String[] args) {
        Prob120_Triangle problem = new Prob120_Triangle();
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>(); t.add(2); list.add(t);
        t = new ArrayList<>(); t.add(3); t.add(4); list.add(t);
        System.out.println(problem.minimumTotal(list));
        System.out.println(problem.minimumTotalWithEditing(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        int dp[] = new int[triangle.size()+1];
        int n = triangle.size();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <=i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotalWithEditing(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j =0; j < triangle.get(i).size(); j++) {
                int top = j < triangle.get(i-1).size() ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                int topleft = j-1 >= 0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int temp = triangle.get(i).get(j) + Math.min(top, topleft);
                triangle.get(i).set(j, temp);
            }
        }
        return triangle.get(triangle.size()-1).stream().min(Integer::compare).orElse(0);
    }

    public int minimumTotalTLE(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        minimumTotal(triangle, 0, 0, 0);
        int t = min;
        min = Integer.MAX_VALUE;
        return t;
    }

    private static int min = Integer.MAX_VALUE;

    private void minimumTotal(List<List<Integer>> triangle, int sum, int row, int col) {
        if (row == triangle.size()-1) {
            min = Math.min(min, sum+triangle.get(row).get(col));
            return;
        }
        minimumTotal(triangle, sum+triangle.get(row).get(col), row+1, col);
        if (col+1 < triangle.get(row+1).size()) minimumTotal(triangle, sum+triangle.get(row).get(col), row+1, col+1);
    }
}

/*
2
3 4
6 5 7
4 1 8 3     11 10 10 3

adjacent numbers? within 1 distance and greater than current pos, 0 -> 0 and 1; 1 -> 1, 2; 2 -> 2,3

naive:
    base case: last row reached, update min if the running min is smaller than the resultant min
    make recursive call for each cell in the list
    return result_min

Bottom-Up:
for each row: i:
    for each col in i: j:
        add min of the row[i-1][j], row[i-1][j-1] if any of them are valid otherwise just add whatever is valid since u dont have option

at the last row select the min sum

*/