package com.D1_arrays;
// https://leetcode.com/problems/asteroid-collision

import java.util.*;

public class Q16_AsteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = asteroidCollision(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] asteroidCollision(int[] asteroids) {
        /* Rules
            1 -> if two asteroids meet, the smaller one will explode
            2 -> if both are equal, both will explode
            3 -> two asteroids moving in the same direction will never meet
        */
        Stack<Integer> st = new Stack<>();

        for(int i : asteroids) {
            if(i > 0) {
                st.push(i);
            }
            else {  // i is negative
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(i)) {
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0) {
                    st.push(i);
                }
                // both element are equal
                else if(i + st.peek() == 0) {
                    st.pop();
                }
            }
        }

        int[] res = new int[st.size()];
        for(int i = res.length-1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
