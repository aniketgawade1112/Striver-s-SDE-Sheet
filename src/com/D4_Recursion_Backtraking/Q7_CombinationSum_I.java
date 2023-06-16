package com.D4_Recursion_Backtraking;
// The same number may be chosen from candidates an unlimited number of times.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q7_CombinationSum_I {
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
        for(List<Integer> list : combinationSum(arr, target)) {
            for(Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
