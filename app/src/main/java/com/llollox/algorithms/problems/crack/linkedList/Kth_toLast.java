package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

public class Kth_toLast {


    /*
        Implement an algorithm to find the kth to last element of a singly linked list.
     */

    public ListNode kthToLast(ListNode head, int kToLast)  {

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        for (int i=0; i<kToLast; i++) {
            fastRunner = fastRunner.next;
        }

        while (fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }
}
