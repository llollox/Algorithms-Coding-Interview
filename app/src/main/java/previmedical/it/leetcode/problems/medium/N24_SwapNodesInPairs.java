package previmedical.it.leetcode.problems.medium;

import previmedical.it.leetcode.models.ListNode;

public class N24_SwapNodesInPairs {

    /*
        Given a linked list, swap every two adjacent nodes and return its head.
        You may not modify the values in the list's nodes, only nodes itself may be changed.

        Example:

        Given 1->2->3->4, you should return the list as 2->1->4->3.

        1->2->3->4
        2->1->3->4

     */


    public ListNode swapNodeInPairs(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (prev == null) {
                head = cur.next;
            }

            swapWithNext(cur, prev, cur.next);

            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    private void swapWithNext(ListNode node, ListNode prev, ListNode next) {
        node.next = next.next; // 1 -> 3
        if (prev != null) {
            prev.next = next;
        }
        next.next = node; // 2 -> 1
    }
}
