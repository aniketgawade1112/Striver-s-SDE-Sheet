package com.D4_Recursion_Backtraking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Given an array nums of distinct integers, return all the possible permutations.

public class Q5_Permutation_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(List<Integer> list : permute(arr)) {
            for(Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> permute(int[] nums) {
        // Time & Space Complexity -> O(2^n)
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue;   // element already exist skip
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
