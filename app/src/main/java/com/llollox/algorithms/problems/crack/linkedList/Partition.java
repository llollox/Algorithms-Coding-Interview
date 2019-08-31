package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

public class Partition {

    public ListNode partition(ListNode head, int value) {

        if (head == null) {
            return null;
        }

        ListNode lower = null;
        ListNode startLower = null;
        ListNode greater = null;
        ListNode startGreater = null;

        ListNode current = head;

        while (current != null) {

            if (current.val < value) {

                if (lower == null) {
                    lower = current;
                    startLower = current;

                    current = current.next;
                    lower.next = null;
                }
                else {
                    lower.next = current;

                    current = current.next;
                    lower = lower.next;
                    lower.next = null;
                }
            }
            else {

                if (greater == null) {
                    greater = current;
                    startGreater = current;

                    current = current.next;
                    greater.next = null;
                }
                else {
                    greater.next = current;
                    current = current.next;
                    greater = greater.next;
                    greater.next = null;
                }
            }
        }

        if (lower != null) {
            lower.next = startGreater;
        }

        return startLower;
    }

}
