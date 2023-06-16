package com.D1_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q3_Missing_Repeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        missingAndRepeating(arr, n);
    }
    static void missingRepeating(int[] arr, int n) {
        /* Sort the input array.
        Traverse the array and check for missing and repeating.
        Time Complexity --> O(NlogN)  || Space Complexity --> O(1) */
        Arrays.sort(arr);
        int miss = 0, repeat = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i + 1]) {
                repeat = arr[i];
            }
            if ((arr[i+1] - arr[i]) != 1) {
                miss = i+1;
            }
        }
        System.out.println("Missing Number is: " + miss + " Repeating Number is: " + repeat);
    }
    static void missing(int[] arr, int n) {
        /* Take a substitute array of size N+1 and initialize it with 0.
        Traverse the given array and increase the value of substitute[arr[i]] by one .
        Then again traverse the substitute array starting from index 1 to N. */
        // Time Complexity --> O(N)  || Space Complexity --> O(N)
        int[] ans = new int[n+1];
        for (int i = 0; i < n; i++) {
            ans[arr[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i] == 0 ) {
                System.out.println("Missing Number is: " + i);
            }
            if (ans[i] > 1) {
                System.out.println("Repeating Number is: " + i);
            }
        }
    }
    static void missingAndRepeating(int[] arr, int n) {
        // Time Complexity --> O(N) || Space Complexity --> O(1)
        for (int i = 0; i < n; i++) {
            // While traversing, use the absolute value of every element as an index and
            // make the value at this index negative to mark it visited.
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            }
            //  If something is already marked negative then this is the repeating element.
            else {
                System.out.println("Repeating Number is: " + abs_val);
            }
        }
        // for missing number look for a positive value.
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                System.out.println("Missing Number is: " + (i+1));
            }
        }
    }
}
