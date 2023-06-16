package com.D1_arrays;

import java.util.Scanner;

public class Q8_ReorganizeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(reorganizeString(s));
    }
    static String reorganizeString(String s) {
        int n = s.length();
        // 1.count letter appearance and store in freq[i]
        int[] freq = new int[26];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        // 2. find the letter with the largest occurrence
        int max = 0, letter = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        if(max > (n + 1) / 2) return "";

        // 3. put the letter into even index number (0, 2, 4 ...) char array
        char[] res = new char[n];
        int idx = 0;
        while(freq[letter] > 0) {
            res[idx] = (char)(letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        //4.put the rest into the array
        for(int i = 0; i < 26; i++) {
            while(freq[i] > 0) {
                if(idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        return String.valueOf(res);
    }
}
