package com.D5_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cows = sc.nextInt();
        int[] stalls = new int[n];
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }
        int ans = aggressiveCows(stalls, cows);
        System.out.println(ans);
    }
    static int aggressiveCows(int[] stalls,int cows) {
        Arrays.sort(stalls);
        int start = 0, maxi = -1;
        int ans = -1;

        for(int i : stalls) {
            maxi = Math.max(maxi, i);
        }
        int end = maxi;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(stalls, cows, mid)) {
                ans = mid;
                start = mid + 1;    // because I want to find maximum
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] stalls, int cows, int mid) {
        int cowCount = 1;
        int lastPos = stalls[0];
        for (int stall : stalls) {
            if (stall - lastPos >= mid) {
                cowCount++;
                if (cowCount == cows) {
                    return true;
                }
                lastPos = stall;
            }
        }
        return false;
    }
}
