package com.D4_Recursion_Backtraking;
// Given a string s, partition s such that every substring of the partition is a palindrome
// Return all possible palindrome partitioning of s.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q10_PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(List<String> list : partition(str)) {
            for(String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }
    static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if(start == s.length()) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for(int i = start; i < s.length(); i++) {
                if(isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    static boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
