package com.D1_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_SortColors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortColor(arr, n);
    }
    // Approach --> sort method O(nlogn)
    // Approach 2 --> Using Two Pass
    static void sortColors(int[] arr, int n) {
        int countZero = 0, countOne = 0;
        for(int num : arr) {
            if (num == 0) countZero++;
            else if(num == 1) countOne++;
        }
        for(int i = 0; i < n; i++) {
            if (i < countZero) {
                arr[i] = 0;
            }
            else if (i < countZero + countOne) {
                arr[i] = 1;
            }
            else {
                arr[i] = 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    // Approach --> Using One Pass
    // Dutch National Flag Algorithm
    static void sortColor(int[] nums, int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
            }
            if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                mid--;
                high--;
            }
            mid++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
