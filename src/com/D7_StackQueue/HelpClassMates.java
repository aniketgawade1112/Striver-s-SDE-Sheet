package com.D7_StackQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class HelpClassMates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        int[] ans = help_classmate(arr, n);
        System.out.println(Arrays.toString(ans));
    }
    static int[] help_classmate(int[] arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = n - 1; i >= 0; i--) {
            while(!st.empty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if(!st.empty()) {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
}
