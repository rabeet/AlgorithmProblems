package LeetCode;

public class Prob37_SudokuSolver {


    public static void main(String[] args) {
        char[][] board ={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }

    static public void solveSudoku(char[][] board) {
        if (!solve(board, 0, 0))
            System.out.println("No Solution Found...");
        else {
            for (int i = 0; i < board.length; i++) {
                if (i != 0 && i % 3 == 0) System.out.println();
                for (int j = 0; j < board.length; j++) {
                    if (j != 0 && j % 3 == 0) System.out.print(" ");
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

    static private boolean solve(char[][] board, int row, int col) {
        if (col == board.length) return solve(board, row + 1, 0);
        if (row == board.length) return true;
        if (board[row][col] != '.') return solve(board, row, col + 1);
        for (int i = 1; i <= board.length; i++) {
            if (isValid(("" + i).charAt(0), board, row, col)) {
                board[row][col] = ("" + i).charAt(0);
                if (solve(board, row, col + 1))
                    return true;
                else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static private boolean isValid(char c, char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++)
            if (board[row][i] == c || board[i][col] == c) return false;

        // to find box: go from i = row-(row%3), j = col-(col%3) to i+2 and j+2
        for (int i = row - (row % 3); i < row - (row % 3) + 3; i++) {
            for (int j = col - (col % 3); j < col - (col % 3) + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;
    }
/*
Use Backtracking...

solve method returns boolean:

if col >= board_size return solve(row+1, 0)
if row >= board_size return true

for each col in provided row:
    if the cell is blank:
        get valid num:
            if found:
                place it and call on next cell
                if above result is good
                    return true
                else backtrack
            if not found:
                backtrack
    else continue to next cell

return false
*/

//    public static void main(String[] args) {
//        Prob37_SudokuSolver solver = new Prob37_SudokuSolver();
//        char[][] board ={{'5','3','1','2','7','6','.','.','.'},
//                        {'6','.','.','1','9','5','.','.','.'},
//                        {'.','9','8','.','.','.','.','6','.'},
//                        {'8','.','.','.','6','.','.','.','3'},
//                        {'4','.','.','8','.','3','.','.','1'},
//                        {'7','.','.','.','2','.','.','.','6'},
//                        {'.','6','.','.','.','.','2','8','.'},
//                        {'.','.','.','4','1','9','.','.','5'},
//                        {'.','.','.','.','8','.','.','7','9'}};
//        solver.solveSudoku(board);
//
//    }
//
//    public void solveSudoku(char[][] board) {
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < board.length; i++)
//            for (int j = 0; j < board.length; j++)
//                if (board[i][j] != '.')
//                    addtoSet(board[i][j], set, i, j);
//        fillBoard(board, set, 0, 0);
//    }
//
//    private static boolean solved = false;
//
//    private void fillBoard(char[][] board, Set<String> set, int rowNum, int start) {
//        Arrays.asList(board).stream().forEach(System.out::println);
//        System.out.println();
//        if (solved) return;
//        if (rowNum >= board.length && start >= board.length) {
//            solved = true;
//            return;
//        }
//        if (rowNum >= board.length) return;
//        if (start >= board.length) {
//            fillBoard(board, set, rowNum+1, 0);
//            return;
//        }
//        if (board[rowNum][start] != '.') {
//            fillBoard(board, set, rowNum, start + 1);
//            return;
//        }
//        for (int i = (int)'1'; i <= (int)'9' && !solved; i++) {
//            if (!exists((char)i, set, rowNum, start)) {
//                addtoSet((char)i, set, rowNum,start);
//                board[rowNum][start] = (char)i;
//                fillBoard(board, set, rowNum, start+1);
//                board[rowNum][start] = '.';
//                removeFromSet((char)i, set, rowNum, start);
//            }
//        }
//    }
//
//    private void addtoSet(char i, Set<String> set, int rowNum, int start) {
//        set.add(i + " in row " + rowNum);
//        set.add(i + " in col " + start);
//        set.add(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
//    }
//
//    private void removeFromSet(char i, Set<String> set, int rowNum, int start) {
//        set.remove(i + " in row " + rowNum);
//        set.remove(i + " in col " + start);
//        set.remove(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
//    }
//
//    private boolean exists(char i, Set<String> set, int rowNum, int start) {
//        return set.contains(i + " in row " + rowNum) ||
//                set.contains(i + " in col " + start) ||
//                set.contains(i + " in box " + (rowNum/3) + "-" + (start/3)+"");
//    }
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