package com.D7_StackQueue.Implementation;

import java.util.LinkedList;
import java.util.Queue;

class MyStack1 {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
        int n = q.size();
        while (n > 1) {
            q.add(q.poll());
            n--;
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
public class Q2_ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStack1 s = new MyStack1();
        s.push(4);
        s.push(2);
        s.push(9);
        s.top();
        s.pop();
    }
}
