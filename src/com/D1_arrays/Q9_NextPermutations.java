package com.D1_arrays;

import java.util.Scanner;

public class Q9_NextPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        nextPermutation(arr);
    }
    public static void nextPermutation(int[] nums) {
        // Time Complexity --> O(N) || Space Complexity --> O(1)
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;

        // 1. find first index that breaks descending order
        while (i >= 0 && nums[i] >= nums[i]) i--;

        if(i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;     // Find rightmost first larger idx
            swap(nums, i, j);                   // example 1 3 5 4 2 --> swap(idx 1, idx 4)
        }

        reverse(nums, i + 1, nums.length - 1);  // Reverse the descending sequence
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
}
