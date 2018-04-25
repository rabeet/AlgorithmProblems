package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob37_SudokuSolver {

    public static void main(String[] args) {
        Prob37_SudokuSolver solver = new Prob37_SudokuSolver();
        char[][] board ={{'5','3','1','2','7','6','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solver.solveSudoku(board);

    }

    public void solveSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] != '.')
                    addtoSet(board[i][j], set, i, j);
        fillBoard(board, set, 0, 0);
    }

    private static boolean solved = false;

    private void fillBoard(char[][] board, Set<String> set, int rowNum, int start) {
        Arrays.asList(board).stream().forEach(System.out::println);
        System.out.println();
        if (solved) return;
        if (rowNum >= board.length && start >= board.length) {
            solved = true;
            return;
        }
        if (rowNum >= board.length) return;
        if (start >= board.length) {
            fillBoard(board, set, rowNum+1, 0);
            return;
        }
        if (board[rowNum][start] != '.') {
            fillBoard(board, set, rowNum, start + 1);
            return;
        }
        for (int i = (int)'1'; i <= (int)'9' && !solved; i++) {
            if (!exists((char)i, set, rowNum, start)) {
                addtoSet((char)i, set, rowNum,start);
                board[rowNum][start] = (char)i;
                fillBoard(board, set, rowNum, start+1);
                board[rowNum][start] = '.';
                removeFromSet((char)i, set, rowNum, start);
            }
        }
    }

    private void addtoSet(char i, Set<String> set, int rowNum, int start) {
        set.add(i + " in row " + rowNum);
        set.add(i + " in col " + start);
        set.add(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
    }

    private void removeFromSet(char i, Set<String> set, int rowNum, int start) {
        set.remove(i + " in row " + rowNum);
        set.remove(i + " in col " + start);
        set.remove(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
    }

    private boolean exists(char i, Set<String> set, int rowNum, int start) {
        return set.contains(i + " in row " + rowNum) ||
                set.contains(i + " in col " + start) ||
                set.contains(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
    }
}

/*


[["5","3","1","2","7","6",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]




BackTracking::
    func filLBoard(board, rowmap, colmap, boxmap, rowNum)
        if (rowNum >= board.length)
            return;
        from i=1 to 9:
            add i in that cell and call next cell
            remove i from that cell

*/