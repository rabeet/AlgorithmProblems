package LeetCode;

public class Prob348_TicTacToe {

    class TicTacToe {

        /**
         * Initialize your data structure here.
         */
        int[][] board;
        int n;
        int[] horizontal;
        int[] vertical;
        int rightDiag;
        int leftDiag;

        public TicTacToe(int n) {
            this.board = new int[n][n];
            this.n = n;
            this.horizontal = new int[n];
            this.vertical = new int[n];
            this.rightDiag = 0;
            this.leftDiag = 0;
        }

        // O(1)
        public int move2(int row, int col, int player) {
            // Add 1 if player 1, add -1 if player 2 and compare to +n or -n
            // for diagonals either compare row == col or row+col == n-1
            // does not use 2d array
            if (player == 1) {
                if (++horizontal[row] == n) return player;
                if (++vertical[col] == n) return player;
                if (row == col && ++rightDiag == n) return player;
                if (row + col == n-1 && ++leftDiag == n) return player;
            } else {
                if (--horizontal[row] == -n) return player;
                if (--vertical[col] == -n) return player;
                if (row == col && --rightDiag == -n) return player;
                if (row + col == n-1 && --leftDiag == -n) return player;
            }
            return 0;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        //O(n)
        public int move(int row, int col, int player) {
            // Add 1 if player 1, add -1 if player 2 and compare to +n or -n
            // guaranteed to be valid
            board[row][col] = player;
            if (player == 1) {
                if (++horizontal[row] == n) return player;
                if (++vertical[col] == n) return player;
            } else {
                if (--horizontal[row] == -n) return player;
                if (--vertical[col] == -n) return player;
            }
            if (wonDiagonal(player)) return player;
            return 0;
        }

        private boolean wonDiagonal(int player) {
            int r1 = 0, c1 = 0, r2 = 0, c2 = n - 1;
            boolean ans = true;
            for (int i = 0; i < n; i++) {
                if (board[r1++][c1++] != player) {
                    ans = false;
                    break;
                }
            }
            if (ans) return ans;
            for (int i = 0; i < n; i++) {
                if (board[r2++][c2--] != player) {
                    return false;
                }
            }
            return true;
        }
    }
}
