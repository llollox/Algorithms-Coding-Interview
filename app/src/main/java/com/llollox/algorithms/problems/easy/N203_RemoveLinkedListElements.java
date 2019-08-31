package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N203_RemoveLinkedListElements {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /*

    Remove all elements from a linked list of integers that have value val.
    Example:
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5

    1->2->6->3->4->5->6

    // se il prossimo e' == 6
        // allora mi attacco al prossimo del prossimo

    */

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        else {
            if (head.val == val) {
                return removeElements(head.next,val);
            }
            else {
                // Se il prossimo e' val
                if (head.next != null && head.next.val == val) {
                    // Il mio prossimo e' il prossimo del prossimo.
                    head.next = head.next.next;
                }

                head.next = removeElements(head.next,val);
                return head;
            }
        }

    }

    public void test() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(6);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next.next = new ListNode(6);

        ListNode output = this.removeElements(l, 6);

        Log.w("TEST", output.toString());
    }

}
