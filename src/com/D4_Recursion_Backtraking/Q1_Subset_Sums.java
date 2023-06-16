package com.D4_Recursion_Backtraking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
// Given a list arr of N integers, print sums of all subsets in it.
public class Q1_Subset_Sums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for(Integer i : subsetSums(arr, n)) {
            System.out.print(i + " ");
        }
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // T.C. -> O(2^n) + O(2^n log(2^n))
        // S.c. -> O(2^n)
        ArrayList<Integer> ans = new ArrayList<>();
        func(0, 0, arr, n, ans);
        Collections.sort(ans);
        return ans;
    }
    static void func(int ind, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> ans) {
        if(ind == n) {
            ans.add(sum);
            return;
        }
        // pick the element
        func(ind + 1, sum + arr.get(ind), arr, n, ans);

        // do not pick the element
        func(ind + 1, sum, arr, n, ans);
    }
}
