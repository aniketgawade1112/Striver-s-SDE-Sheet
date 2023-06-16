package com.D1_arrays;
// https://leetcode.com/problems/search-a-2d-matrix/

import java.util.Scanner;

public class Q13_SearchIn2D {
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
        int target = sc.nextInt();
        System.out.println(searchMatrix(arr, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0) {
            if(matrix[row][col] > target) {
                col--;    // lies in same row, so search in columns
            }
            else if(matrix[row][col] < target) {
                row++;    // row++
            }
            else {
                return true;
            }
        }
        return false;
    }
}
