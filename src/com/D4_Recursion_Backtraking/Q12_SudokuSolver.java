package com.D4_Recursion_Backtraking;

public class Q12_SudokuSolver {
    public static void main(String[] args) {

    }
    public void solveSudoku(char[][] board) {
        // T.C. -> O(9^n^2)for each cell in the n2 board, we have 9 possible numbers.
        if(board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {  // try 1 - 9
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;    // put c for this cell

                            if(solve(board))
                                return true;    // if it is solution return true
                            else
                                board[i][j] = '.';  // otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) {    // checking for row
                return false;
            }
            if(board[row][i] == c) {    // checking for col
                return false;
            }
            // checking for (3 x 3) sub-board
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
