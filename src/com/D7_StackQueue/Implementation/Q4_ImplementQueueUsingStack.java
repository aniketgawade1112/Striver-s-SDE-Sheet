package com.D7_StackQueue.Implementation;

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
        return;
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty();
    }
}
public class Q4_ImplementQueueUsingStack {
    public static void main(String[] args) {

    }
}
