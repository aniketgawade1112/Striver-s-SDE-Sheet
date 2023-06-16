package com.D4_Recursion_Backtraking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q9_CombinationSum_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        for(List<Integer> list : combinationSum3(k, n)) {
            for(Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> combinationSum3(int k, int n) {
        // Time & Space Complexity -> O(9^k)
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, 9, list, new ArrayList<>(), k, n);
        return list;
    }
    static void backtrack(int start, int end, List<List<Integer>> list, List<Integer> tempList, int k, int target) {
        if(target == 0 && tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i <= end; i++) {
            tempList.add(i);
            backtrack(i + 1, 9, list, tempList, k, target - i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
