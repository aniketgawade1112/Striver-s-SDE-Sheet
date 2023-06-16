package com.D4_Recursion_Backtraking;


import java.util.Arrays;
import java.util.Scanner;

public class Q4_Next_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nextPermutation(arr)));
    }
    static int[] nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return new int[0];
        int i = nums.length - 2;
        // 1. find first index that breaks increasing order from last
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;

        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) j--;  // Find rightmost first larger idx
            swap(nums, i, j);       // example 1 3 5 4 2 --> swap(idx 1, idx 4)
        }
        reverse(nums, i + 1, nums.length - 1); // Reverse the descending sequence

        return nums;
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
