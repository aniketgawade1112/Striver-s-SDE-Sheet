package com.D7_StackQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q6_NextGreater_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        int[] res = nextGreaterElements(arr);
        System.out.println(Arrays.toString(res));
    }
    static int[] nextGreaterElement(int[] nums) {
        // Time Complexity -> O(n^2) || Space Complexity -> O(1)
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = -1;
            for(int j = 1; j < n; j++) {
                if(nums[(i + j) % n] > nums[i]) {
                    ans[i] = nums[(i + j) % n];
                    break;
                }
            }
        }
        return ans;
    }
    static int[] nextGreaterElements(int[] nums) {
        // Time Complexity -> O(n) || Space Complexity -> O(n)
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 2 * n - 1; i >= 0; i--) {
            while(!st.empty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if(i < n) {
                if(!st.empty()) {
                    ans[i] = st.peek();
                }
                else {
                    ans[i] = -1;
                }
            }
            st.push(nums[i % n]);
        }
        return ans;
    }
}
