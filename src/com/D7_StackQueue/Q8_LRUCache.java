package com.D7_StackQueue;

import java.util.HashMap;

public class Q8_LRUCache {

}
class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);   // right after head
            return node.value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(tail.prev);  // remove LRU -> previous of tail
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    static class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
