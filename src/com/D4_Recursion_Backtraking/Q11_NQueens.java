package com.D4_Recursion_Backtraking;

import java.util.ArrayList;
import java.util.List;

public class Q11_NQueens {
    public static void main(String[] args) {
        int n = 4;
        for(List<String> list : solveNQueens(n)) {
            for(String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];    // building chess board
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }
     static void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        for(int i = 0; i < board.length; i++) {
            if(isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    static boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(y - j) || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }
    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
