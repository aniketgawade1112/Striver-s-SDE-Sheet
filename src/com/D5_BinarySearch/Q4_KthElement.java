package com.D5_BinarySearch;
// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
import java.util.Arrays;
import java.util.Scanner;

public class Q4_KthElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int ans = kthElement(arr1, arr2, n, m, k);
        System.out.println(ans);
    }
    static int kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        int[] arr = new int[n + m];
        if (n >= 0) System.arraycopy(arr1, 0, arr, 0, n);
        if (m >= 0) System.arraycopy(arr2, 0, arr, n, m);
        Arrays.sort(arr);
        return arr[k - 1];
    }

}
