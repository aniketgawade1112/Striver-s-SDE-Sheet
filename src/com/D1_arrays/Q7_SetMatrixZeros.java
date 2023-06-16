package com.D1_arrays;
// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7_SetMatrixZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        setZeros(arr);
    }
    static void setZero(int[][] matrix) {
        // Time Complexity - O(M x N) + O(M + N)
        // Space Complexity - O(M) + O(N)
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        // traverse the loop to check 0
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        // make whole row as zeros
        for (Integer integer : row) {
            for (int j = 0; j < n; j++) {
                matrix[integer][j] = 0;
            }
        }

        // make whole col as zeros
        for (Integer integer : col) {
            for (int j = 0; j < m; j++) {
                matrix[j][integer] = 0;
            }
        }
    }
    static void setZeros(int[][] matrix) {
        // Time Complexity - O(2 x (M x N))
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
