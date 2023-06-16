package com.D1_arrays;

// https://leetcode.com/problems/3sum/
/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets. */

import java.util.*;

public class Q17_3Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(List<Integer> list : threeSum(arr)) {
            for(int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> threeSums(int[] nums) {
        // TC -> O(n^2) || SC -> O(N)
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(sum > 0) right--;
                else
                    left++;
            }
        }
        list.addAll(set);
        return list;
    }
    static List<List<Integer>> threeSum(int[] nums) {
        // Time Complexity --> O(N^2) || Space Complexity --> O(1)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {        // duplicates are avoided
                // looking for b + c = -a;
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];

                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // similar lo and hi are ignored so make lo++ and hi--
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;

                        lo++; hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else
                        hi--;
                }
            }
        }
        return ans;
    }
}
