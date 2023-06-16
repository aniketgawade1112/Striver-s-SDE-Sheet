package com.D1_arrays;
// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

import java.util.HashMap;
import java.util.Scanner;

public class Q22_LargeSubWithSumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxLen(arr);
        System.out.println(ans);
    }
    static int largestSub(int[] arr) {
        // Brute Force Approach
        // Time Complexity --> O(N^2) || Space Complexity --> O(1)
        int n = arr.length;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }
    static int maxLen(int[] arr) {
        // Time Complexity --> O(N) || Space Complexity --> O(N)
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == 0) {
                maxLen = Math.max(maxLen, i+1);
            }
            if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
