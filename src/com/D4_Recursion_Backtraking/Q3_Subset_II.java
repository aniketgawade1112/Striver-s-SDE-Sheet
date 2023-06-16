package com.D4_Recursion_Backtraking;

// Given an integer array nums that may contain duplicates, return all possible subsets

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q3_Subset_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(List<Integer> list : subsetsWithDup(arr)) {
            System.out.print("[");
            for(Integer ans : list) {
                System.out.print(ans + "");
            }
            System.out.print("]");
            System.out.println();
        }

    }
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Time Complexity --> O(2^n) + O(nlogn)
        // Space Complexity --> O(2^n)
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;   // skip duplicates
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
