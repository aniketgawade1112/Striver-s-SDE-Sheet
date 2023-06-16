package com.D1_arrays;
// https://leetcode.com/problems/majority-element/

import java.util.HashMap;
import java.util.Scanner;

public class Q14_MajorityElement_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = majorityEle(arr);
        System.out.println(ans);
    }
    static int majorityElement(int[] nums) {
        // Time Complexity -> O(N^2) || Space Complexity --> O(1)
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
                if (count > (n / 2)) return i;
            }
            count = 0;
        }
        return 0;
    }
    static int majority(int[] a, int size) {
        // Time Complexity -> O(N) || Space Complexity --> O(N)
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) {
            if(map.containsKey(a[i])) {
                map.put(a[i],map.get(a[i]) + 1);
            }
            else {
                map.put(a[i],1);
            }
            if(map.get(a[i]) > size/2) {
                return a[i];
            }
        }
        return -1;
    }
    static int majorityEle(int[] nums) {
        // Time Complexity -> O(N) || Space Complexity --> O(1)
        // Boyer's moore voting algorithm
        int count = 0;
        int max = 0;

        for(int num : nums) {
            if(count == 0) {
                max = num;
            }
            if(num == max)
                count++;
            else
                count--;
        }
        return max;
    }
}
