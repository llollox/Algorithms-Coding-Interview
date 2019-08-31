package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

import java.util.HashSet;

public class RemoveDuplicates {


    /*
        Write code to remove duplicates from an unsorted linked list.
        FOLLOW UP
        How would you solve this problem if a temporary buffer is not allowed?
     */

    public ListNode removeDuplicatesWithBuffer(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {

            if (set.contains(current.val)) {

                // Remove node
                previous.next = current.next;
            }
            else {

                // Add new value to discovered set
                set.add(current.val);
                previous = current;
            }

            current = current.next;
        }

        return head;
    }

    public ListNode removeDuplicatesWithoutBuffer(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sorted = new MergeSort().mergeSort(head);
        this.removeDuplicatesWithoutBuffer(sorted, sorted.next);
        return sorted;
    }

    public void removeDuplicatesWithoutBuffer(ListNode previous, ListNode node) {
        if (node != null) {
            if (previous.val == node.val) {
                previous.next = node.next;
                this.removeDuplicatesWithoutBuffer(previous, node.next);
            }
            else {
                this.removeDuplicatesWithoutBuffer(node, node.next);
            }
        }
    }


}
