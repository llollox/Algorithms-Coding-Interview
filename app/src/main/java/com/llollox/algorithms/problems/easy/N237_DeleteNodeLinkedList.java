package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N237_DeleteNodeLinkedList {

    /*
    Write a function to delete a node (except the tail) in a singly linked list,
    given only access to that node.

    Example 1
    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]

    [4,1,9,9]
           i

    Example 2
    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]

    - The linked list will have at least two elements.
    - All of the nodes' values will be unique.
    - The given node will not be the tail and it will always be a valid node of the linked list.
    - Do not return anything from your function.
    */



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void test() {
        ListNode l = new ListNode(4);
        l.next = new ListNode(5);
        l.next.next = new ListNode(1);
        l.next.next.next = new ListNode(9);

        this.deleteNode(l.next);

        Log.w("TEST", l.toString());
    }
}
