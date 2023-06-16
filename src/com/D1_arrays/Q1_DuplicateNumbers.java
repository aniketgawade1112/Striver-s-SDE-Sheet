package com.D1_arrays;

// https://leetcode.com/problems/find-the-duplicate-number/

import java.util.Scanner;

public class Q1_DuplicateNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = findDuplicate(arr);
        System.out.println(ans);
    }
    // Approach - Brute Force O(n^2)
    // Sort and Iterate O(nlogn)
    // HashMap (extra space)
    // Slow-Fast Pointer Approach
    static int findDuplicate(int[] nums) {
        // Optimized Approach
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
