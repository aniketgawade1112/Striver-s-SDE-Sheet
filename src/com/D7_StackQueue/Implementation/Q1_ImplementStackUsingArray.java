package com.D7_StackQueue.Implementation;

class MyStack {
    int size = 10000;
    int[] arr = new int[size];
    int top = -1;

    void push(int x) {
        top++;
        arr[top] = x;
    }

    int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }
}
public class Q1_ImplementStackUsingArray {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(5);
        s.push(8);
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.size());
    }
}
