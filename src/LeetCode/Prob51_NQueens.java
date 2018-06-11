package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> b = new ArrayList<>();
        String text = "";
        for (int i = 0; i < n; i++) text += ".";
        for (int i = 0; i < n; i++) b.add(text);
        solve(ans, b, n, 0);
        return ans;
    }

    /*
    "Q..."
    "...."
    "...."
    "...."

    */

    private void solve(List<List<String>> ans, List<String> built_list, int n, int rowNum) {
        if (rowNum == n) {
            ans.add(new ArrayList<String>(built_list));
            return;
        }
        for (int colNum = 0; colNum < n; colNum++) {
            if (canPlace(built_list, rowNum, colNum)) {
                char[] row = built_list.get(rowNum).toCharArray();
                row[colNum] = 'Q';
                built_list.set(rowNum, new String(row));
                solve(ans, built_list, n, rowNum+1);
                row[colNum] = '.';
                built_list.set(rowNum, new String(row));
            }
        }
    }

    // only check top to bot, current to top left and current to top right since the ones at bottom are still pending
    private boolean canPlace(List<String> b, int r, int c) {
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).charAt(c) == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (b.get(i).charAt(j) == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j < b.size(); i--, j++) {
            if (b.get(i).charAt(j) == 'Q') return false;
        }
        // for (int i = r, j = c; i < b.size() && j >= 0; i++, j--) {
        //     if (b.get(i).charAt(j) == 'Q') return false;
        // }
        // for (int i = r, j = c; i < b.size() && j < b.size(); i++, j++) {
        //     if (b.get(i).charAt(j) == 'Q') return false;
        // }
        return true;
    }
}

/*
Use backtracking..

solve(ans List, built List, int n, int colNum):
    if (colNum == n) add builtList to ans list and return
    from 0 to n: (rowNum)
        if can place queen in rowNum and colNum then place
        if (solve(ans, built_list, n, colNum+1)):
            reset row;
        else:
            remove queen from the placed location
    return false
*/
