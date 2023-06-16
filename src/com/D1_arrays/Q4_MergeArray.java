package com.D1_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q4_MergeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        merge(nums1, m, nums2, n);
    }
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Time Complexity --> O(NlogN)  || Space Complexity --> O(1)
        for(int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    static void mergeArray(int[] nums1, int m, int[] nums2, int n) {
        // Time Complexity --> O(N)  || Space Complexity --> O(1)
        int i = m - 1, j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }
}
