package com.D1_arrays;
// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

import java.util.Scanner;

public class Q10_CountInversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans  = inversion(arr, n);
        System.out.println(ans);
    }
    static int inversionCount(int[] arr, int n) {
        // Time Complexity --> O(N^2) || Space Complexity --> O(1)
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i < j && arr[i] > arr[j]) count++;
            }
        }
        return count;
    }
    static int inversion(int[] arr, int n) {
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }
    static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, inv_count = 0;
        if (left < right) {
            mid = (left + right) / 2;

            inv_count += mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid + 1, right);

            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }
    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int inv_count = 0;
        int i = left;
        int j = mid;
        int k = left;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }
        return inv_count;
    }
}
