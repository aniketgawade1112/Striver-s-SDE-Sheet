package com.D5_BinarySearch;

import java.util.Scanner;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class Q2_SingleElement {
    public static void main(String[] args) {
        //  Single Element in a Sorted Array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = singleNonDuplicate(arr);
        System.out.println(ans);
    }
    static int singleNonDuplicate(int[] nums) {
        // T.C. -> O(logN) || S.C. -> O(1)
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }
}
