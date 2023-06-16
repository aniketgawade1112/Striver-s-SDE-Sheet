package com.D1_arrays;
// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q23_PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(List<Integer> list : generate(n)) {
            for(int ans : list) {
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> generate(int numRows) {
        // Time Complexity - O(numRows^2)
        // Space Complexity - O(numRows^2)
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            // no.of rows are always equal to the no.col
            for (int j = 0; j <= i; j++) {
                // if it is first col or last col
                if (j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            ans.add(row);
        }
        return ans;
    }
}
