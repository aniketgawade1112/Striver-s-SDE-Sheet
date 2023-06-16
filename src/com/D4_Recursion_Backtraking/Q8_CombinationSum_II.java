package com.D4_Recursion_Backtraking;
// can not use same element

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q8_CombinationSum_II {
    public static void main(String[] args) {
        // Time Complexity - O(2^t * k)     // t -> target, k -> avg length
        // Space Complexity - O(k * x)      // x -> no. of combinations
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        for(List<Integer> list : combinationSum2(arr, target)) {
            for(Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if(remain < 0) {
            return;
        }
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i - 1]) {
                    continue;   // skip duplicates
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
