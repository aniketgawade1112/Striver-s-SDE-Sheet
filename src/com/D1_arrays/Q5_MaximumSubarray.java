package com.arrays;
// https://leetcode.com/problems/maximum-subarray/

import java.util.Scanner;

public class Q5_MaximumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
    static int maxSub(int[] arr) {
        // Time Complexity --> O(N^2)  || Space Complexity --> O(1)
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    static int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        // Time Complexity --> O(N)  || Space Complexity --> O(1)
        int sum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
