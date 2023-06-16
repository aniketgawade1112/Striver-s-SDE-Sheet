package com.D7_StackQueue.Implementation;

class Queue {
    private final int[] arr;
    private int front, rear, currSize;
    private final int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
        currSize = 0;
    }

    public void push(int newElement) {
        if (currSize == maxSize) {
            System.out.println("Queue is Full\nExiting...");
            System.exit(1);
        }
        if (rear == -1) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % maxSize;
        }
        arr[rear] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }

    public int pop() {
        if (front == -1) {
            System.out.println("Queue Empty/nExiting...");
            System.exit(1);
        }
        int popped = arr[front];
        if (currSize == 1) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % maxSize;
        }
        currSize--;
        return popped;
    }

    public int top() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[front];
    }

    public int size() {
        return currSize;
    }
}
public class Q3_ImplementQueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}
