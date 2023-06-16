package com.D1_arrays;
// https://leetcode.com/problems/rotate-image/

import java.util.Scanner;

public class Q12_RotateImage {
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
        rotateImage(arr);
    }
    static void rotateImage(int[][] matrix) {
        int n = matrix.length;
        int m = matrix.length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
    static void rotate(int[][] matrix) {
        // Time Complexity --> O(N^2) || Space Complexity --> O(1)
        int n = matrix.length;
        // take the transpose of matrix
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // swap 1st column with last column
        for(int i = 0; i < n; i++) {
            int start = 0;
            int end = n -1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
