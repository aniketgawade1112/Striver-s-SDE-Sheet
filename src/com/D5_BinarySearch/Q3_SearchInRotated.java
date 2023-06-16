package com.D5_BinarySearch;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
import java.util.Scanner;

public class Q3_SearchInRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(arr, target));
    }
    static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // check if the left half is sorted or not
            if(nums[start] <= nums[mid]) {
                // check if target is lies on left half or not
                if(target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
