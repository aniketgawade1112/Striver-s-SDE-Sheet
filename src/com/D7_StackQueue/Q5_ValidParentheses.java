package com.D7_StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Q5_ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(isValid(str));
    }
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else {
                if(!st.isEmpty() && match(st.peek(), s.charAt(i))) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    static boolean match(char open, char close) {
        if(open == '(' && close == ')') return true;
        if(open == '{' && close == '}') return true;
        if(open == '[' && close == ']') return true;
        return false;
    }
}
