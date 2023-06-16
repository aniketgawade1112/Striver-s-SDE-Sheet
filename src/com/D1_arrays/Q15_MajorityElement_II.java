package com.D1_arrays;
// https://leetcode.com/problems/majority-element-ii/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15_MajorityElement_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> ans;
        ans = majorityElement(arr);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }

    }
    static List<Integer> majorityEle(int[] nums) {
        // Time Complexity -> O(N^2) || Space Complexity --> O(1)
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count > n / 3) {
                ans.add(num);
            }
        }
        return ans;
    }
    static List<Integer> majorityElement(int[] nums) {
        // Time Complexity -> O(N) || Space Complexity --> O(1)
        // Boyer's moore voting algorithm
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int ele : nums) {
            if (ele == num1) {
                count1++;
            } else if (ele == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = ele;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = ele;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int ele : nums) {
            if (ele == num1)
                count1++;
            else if (ele == num2)
                count2++;
        }
        if(count1 > len / 3) ans.add(num1);
        if(count2 > len / 3) ans.add(num2);
        return ans;
    }
}
