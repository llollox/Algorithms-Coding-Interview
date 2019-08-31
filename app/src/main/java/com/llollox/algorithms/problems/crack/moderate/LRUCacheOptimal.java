package com.llollox.algorithms.problems.crack.moderate;

import java.util.HashMap;

public class LRUCacheOptimal {

    public static class LinkedListNode {
        public LinkedListNode prev;
        public LinkedListNode next;
        private int key;
        private String value;

        public LinkedListNode(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, LinkedListNode> map = new HashMap<>();
    private LinkedListNode head;
    private LinkedListNode tail;
    private int maxSize;

    public LRUCacheOptimal(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getValue(int key) {
        LinkedListNode item = this.map.get(key);
        if (item == null) {
            return null;
        }
        else {
            this.removeItemFromLinkedList(item);
            this.insertItemAtEndOfLinkedList(item);
            return item.value;
        }
    }

    public void insert(int key, String value) {
        if (this.map.size() == this.maxSize) {
            this.removeKey(this.head.key);
        }

        LinkedListNode newNode = new LinkedListNode(key, value);
        this.insertItemAtEndOfLinkedList(newNode);
        this.map.put(key, newNode);
    }

    private void insertItemAtEndOfLinkedList(LinkedListNode item) {
        if (this.tail == null) {
            this.tail = item;
            this.head = item; // If tail is null means that there are no item at all
        }
        else {
            this.tail.next = item;
            item.prev = this.tail;
            this.tail = item;
        }
    }

    private void removeKey(int key) {
        LinkedListNode item = this.map.get(key);
        if (item != null) {
            this.removeItemFromLinkedList(item);
            this.map.remove(key);
        }
    }

    private void removeItemFromLinkedList(LinkedListNode item) {
        if (this.head == item) {
            this.head = item.next;
            item.next = null;
            if (this.head == null) {
                this.tail = null;
            }
            else {
                this.head.prev = null;
            }

        }
        else if (this.tail == item) {
            this.tail = item.prev;
            item.prev = null;

            if (this.tail == null) {
                this.head = null;
            }
            else {
                this.tail.next = null;
            }
        }
        else {
            item.prev.next = item.next;
            item.next.prev = item.prev;
            item.next = null;
            item.prev = null;
        }
    }
}

