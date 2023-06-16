package com.D1_arrays;

// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q21_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = longestConsecutives(arr);
        System.out.println(ans);
    }
    static int longestConsecutive(int[] nums) {
        // Brute Force Approach --> O(NLogN) || Space Complexity --> O(1)
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }
    static int longestConsecutives(int[] nums) {
        // Time Complexity --> O(N) || Space Complexity --> O(N)
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for(int num : nums) {
            if(!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while(hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
