package com.D1_arrays;
// https://leetcode.com/problems/reverse-pairs/
/* Given an integer array nums, return the number of reverse pairs in the array.
                A reverse pair is a pair (i, j) where:
                0 <= i < j < nums.length and
                nums[i] > 2 * nums[j].
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Q19_ReversePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = reversePairs(arr);
        System.out.println(ans);
    }
    static int reversePair(int[] nums) {
        // Brute Force Approach
        // Time Complexity --> O(N^2) || Space Complexity --> O(1)
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j] * 2) {
                    count++;
                }
            }
        }
        return count;
    }
    static int reversePairs(int[] nums) {
        // Time Complexity --> O(NlogN) + O(N) + O(N) || Space Complexity --> O(N)
        return mergeSort(nums, 0, nums.length - 1);
    }
    static int mergeSort(int[] nums, int low, int high) {
        if(low >= high) return 0;

        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid);    // left part
        inv += mergeSort(nums, mid + 1, high);  // right part
        inv += merge(nums, low, mid, high);
        return inv;
    }
    static int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for(int i = low; i <= mid; i++) {
            while(j <= high && nums[i] > ( 2 * (long)nums[j])) {
                j++;
            }
            count += (j - (mid + 1));   // count the no of left element
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            }
            else {
                temp.add(nums[right++]);
            }
        }

        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);

        for(int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return count;
    }
}
