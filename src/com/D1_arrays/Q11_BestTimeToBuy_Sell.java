package com.D1_arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

import java.util.Scanner;

public class Q11_BestTimeToBuy_Sell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
    static int max(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max = Math.max(max, Math.abs(prices[i] - prices[j]));
                }
            }
        }
        return max;
    }
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
