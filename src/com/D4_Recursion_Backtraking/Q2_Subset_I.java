package com.D4_Recursion_Backtraking;

// Given an integer array nums of unique elements, return all possible subsets

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2_Subset_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(List<Integer> list : subsets(arr)) {
            System.out.print("[");
            for(Integer ans : list) {
                System.out.print(ans + "");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    static List<List<Integer>> subsets(int[] nums) {
        // Time & Space Complexity --> O(2^n)
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
