package com.D1_arrays;
// https://leetcode.com/problems/unique-paths/
/* There is a robot on an m x n grid. The robot is initially located at the top-left corner
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can
take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109. */
import java.util.Scanner;

public class Q18_UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = uniquePath(m, n);
        System.out.println(ans);
    }
    // Brute Force Approach (Recursive)
    // Time Complexity --> Exponential || Space Complexity --> Exponential
    static int uniquePaths(int m, int n) {
        return countPath(0, 0, m, n);
    }
    static int countPath(int i, int j, int m, int n) {
        if(i >= m || j>= n)
            return 0;

        if(i == (m - 1) && j == (n - 1))
            return 1;
        else
            return countPath(i + 1, j, m, n) + countPath(i, j + 1, m, n);
    }
    // Optimized Approach DP
    static int uniquePath(int m, int n) {
        // Time Complexity --> O(m - 1) || Space Complexity --> 1
        // formula m + n - 2 C m-1 (nCr formula)
        int N =  m + n - 2;
        int r  = m - 1;
        double res = 1;

        // loop will run till r times
        // ex nCr (10^C 3) then r = (3 x 2 x 1)
        for(int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;    // (10 - 3 + i) / i
        }
        return (int)res;
    }
}
