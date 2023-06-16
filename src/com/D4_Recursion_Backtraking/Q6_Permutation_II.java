package com.D4_Recursion_Backtraking;

// Given a collection of numbers, that might contain duplicates, return all possible unique permutation
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q6_Permutation_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(List<Integer> list : permuteUnique(arr)) {
            for(Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
