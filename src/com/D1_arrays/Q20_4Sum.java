package com.D1_arrays;

// https://leetcode.com/problems/4sum/

import java.util.*;

public class Q20_4Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(List<Integer> list : fourSums(arr, target)) {
            for(int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // TC -> O(n^3) || SC -> O(N)
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // We have to type cast int value to long long
                    // because by default it takes integer value.
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }

    // Time Complexity --> O(N^3) || Space Complexity --> O(1)
    static List<List<Integer>> fourSums(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        int n = nums.length;
        Arrays.sort(nums);

        // Loop for each element in the array
        for (int i = 0; i < n; i++) {
            long target_3 = target - nums[i];
            for (int j = i + 1; j < n; j++) {
                long target_2 = target_3 - nums[j];
                // Left and right pointers
                int front = j + 1;
                int back = n - 1;
                // Reducing to two sum problem
                while (front < back) {
                    long currentSum = nums[front] + nums[back];
                    if (currentSum < target_2) front++;
                    else if (currentSum > target_2) back--;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[front], nums[back]));
                        // Check for skipping duplicates
                        while (front < back && nums[front] == nums[front + 1])  front++;

                        while (front < back && nums[back] == nums[back - 1]) back--;

                        front++;
                        back--;
                    }
                }
                // Processing the duplicates of number 2
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            // Processing the duplicates of number 1
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
