package com.D5_BinarySearch;

import java.util.Scanner;

public class Q5_BookAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = allocateBooks(arr, n, m);
        System.out.println(ans);
    }
    static int allocateBooks(int[] arr, int n, int m) {
        int start = 0, sum = 0;

        for(int num : arr) {
            sum += num;
        }
        int end = sum;
        int ans = -1;

        if (m > n) return ans;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid)) {
                ans = mid;  // store the mid into ans
                end = mid - 1;  // move left because I want minimum
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            }
            else {
                studentCount++;
                // if count > given no.of students or value of arr[i] > mid
                if(studentCount > m || arr[i] > mid) {
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
}
