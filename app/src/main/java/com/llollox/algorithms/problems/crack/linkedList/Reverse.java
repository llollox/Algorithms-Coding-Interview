package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

public class Reverse {

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

}
