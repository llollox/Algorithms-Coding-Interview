package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

public class LinkedListUtil {

    public static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
