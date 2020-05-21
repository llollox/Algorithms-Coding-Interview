package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

import java.util.List;

public class Kth_toLast {


    /*
        Implement an algorithm to find the kth to last element of a singly linked list.
     */

    public ListNode kthToLast(ListNode head, int kToLast)  {

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        for (int i=0; i<kToLast; i++) {
            if (fastRunner == null) {
                return null;
            }
            fastRunner = fastRunner.next;
        }

        while (fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }

    public ListNode kthToLastRecursive(ListNode head, int kthToLast) {
        Index index = new Index();
        return kthToLastRecursiveImpl(head, kthToLast, index);
    }

    private static class Index {
        int val = 0;
    }

    private ListNode kthToLastRecursiveImpl(ListNode node, int kthToLast, Index idx) {
        if (node != null) {
            ListNode returnNode = kthToLastRecursiveImpl(node.next, kthToLast, idx);
            if (returnNode != null) {
                return returnNode;
            }

            idx.val = idx.val + 1;
            if (idx.val == kthToLast) {
                return node;
            }
            return null;
        }
        else {
            idx.val = -1;
            return null;
        }
    }
}
