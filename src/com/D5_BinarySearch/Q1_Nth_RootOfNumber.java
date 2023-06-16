package com.D5_BinarySearch;

public class Q1_Nth_RootOfNumber {
    // Time Complexity: N x log(M x 10^d) || Space Complexity: O(1)
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        getNthRoot(n, m);
    }
    static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-7;

        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            if (multiply(mid, n) < m) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        System.out.println(n + "th root of " + m + " is " + low);
    }
    static double multiply(double num, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * num;
        }
        return ans;
    }
}
