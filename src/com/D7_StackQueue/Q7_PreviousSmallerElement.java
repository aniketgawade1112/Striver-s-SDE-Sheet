package com.D7_StackQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q7_PreviousSmallerElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        int[] ans = previousSmallerElement(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] previousSmallerElement(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(nums[0]);
        ans[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!st.empty() && st.peek() >= nums[i]) {
                st.pop();
            }
            if (st.empty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}
