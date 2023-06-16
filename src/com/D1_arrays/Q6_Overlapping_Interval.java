package com.D1_arrays;

import java.util.*;

public class Q6_Overlapping_Interval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] ans = overlappedInterval(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] overlappedInterval(int[][] intervals) {
        // Time Complexity --> O(NLogN) + O(N) || Space Complexity --> O(N)
        List<int[]> res = new ArrayList<>();

        // if given empty interval
        if(intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // sorted in ascending order
        // pairs
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals) {
            // example : [1,3], [2,4], [6,8]
            // check if 2 <= 3 ?
            if(i[0] <= end) {
                end = Math.max(end, i[1]);  // merge with right max of both interval
            }
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        // whatever the start and end value there add into the res
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
