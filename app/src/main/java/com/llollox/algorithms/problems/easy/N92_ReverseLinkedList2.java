package com.llollox.algorithms.problems.easy;

import com.llollox.algorithms.models.ListNode;

public class N92_ReverseLinkedList2 {

    /*

        Reverse a linked list from position m to n. Do it in one-pass.
        Note: 1 ≤ m ≤ n ≤ length of list.

        Example:
        Input: 1->2->3->4->5->NULL, m = 2, n = 4
        Output: 1->4->3->2->5->NULL

     */


    /*
        Solution. O(n)

        Loop through the nodes taking note of the previous until the counter
        reaches m.
        Save pointer to m-1-th node as prevStart
        Save pointer to m-th node as start

        Than perform reverse until the counter reaches n.
        Than attach the n-th node's next as the next into the list.

        Reverse until counter reaches n+1
        prevStart.next = prev
        start.next = cur

        Than if n == length
            next of last node = null
            returns last node
        else if m == 1
            returns last node
        else if m > 1
            returns head



        counter = 3



       start
        1 -> 2         4 -> 5   m = 2, n = 4
                       4 -> 3 -> 2
                     prev
                           cur

           1 -> 2 -> 3 -> 4 -> 5

           1 -> 2 -> 3
prevStart
         start
               prev
                    cur
                    next

                     3 -> 2 -> 1
          nextTmp = cur.next
          cur.next = prev
          prev = cur
          cur = nextTmp

     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }


//      1   2
        /*
        1 <-2   3
  ps
           prev
               cur
       start
               next
         */


        int count = 0;
        ListNode current = head;
        ListNode prevStart = null;
        ListNode prev = null;

        while (count < m) {
            prevStart = prev;
            prev = current;
            current = current.next;
            count++;
        }

        ListNode start = prev;

        while (count < n) {
            ListNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
            count++;
        }

        start.next = current;

        if (m == 1) {

            return prev;
        }
        else { // m > 1
            prevStart.next = prev;
            return head;
        }
    }
}
