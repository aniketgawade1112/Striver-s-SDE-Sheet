package com.D4_Recursion_Backtraking;

import java.util.ArrayList;

public class Q14_Rat_Maze {
    public static void main(String[] args) {

    }
    private static void solve(int row, int col, int[][] mat, int n, ArrayList<String> ans, String move, int[][] vis) {
        if (row == n - 1 && col == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (row + 1 < n && vis[row + 1][col] == 0 && mat[row + 1][col] == 1) {
            vis[row][col] = 1;
            solve(row + 1, col, mat, n, ans, move + 'D', vis);
            vis[row][col] = 0;
        }

        // left
        if (col - 1 >= 0 && vis[row][col - 1] == 0 && mat[row][col - 1] == 1) {
            vis[row][col] = 1;
            solve(row, col - 1, mat, n, ans, move + 'L', vis);
            vis[row][col] = 0;
        }

        // right
        if (col + 1 < n && vis[row][col + 1] == 0 && mat[row][col + 1] == 1) {
            vis[row][col] = 1;
            solve(row, col + 1, mat, n, ans, move + 'R', vis);
            vis[row][col] = 0;
        }

        // upward
        if (row - 1 >= 0 && vis[row - 1][col] == 0 && mat[row - 1][col] == 1) {
            vis[row][col] = 1;
            solve(row - 1, col, mat, n, ans, move + 'U', vis);
            vis[row][col] = 0;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) {
            solve(0, 0, m, n, ans, "", vis);
        }
        return ans;
    }
}
