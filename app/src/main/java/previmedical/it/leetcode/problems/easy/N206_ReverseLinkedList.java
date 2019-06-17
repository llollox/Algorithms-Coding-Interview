package previmedical.it.leetcode.problems.easy;

import previmedical.it.leetcode.models.ListNode;

public class N206_ReverseLinkedList {

    /*
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:

    A linked list can be reversed either iteratively or recursively.
    Could you implement both?

    Solution. O(n)

     For each node try to set the next of the next as me.
     And then move to the next to the next with a pointer.
     At the end set the next of the head to null.
     ritorno cur

     1 -> 2    3    4    5
                         5 -> 4 -> 3 -> 2 -> 1

   head
                             nextOfNext
                               next
                        cur


    5 -> 4   3 -> 2 -> 1
   head

        cur
            next

        4 -> 5

    // Reverse the pointer
    next.next = cur

    // Move to the next
    cur = next
    next = nextOfNext
    nextOfNext = next.next

     */

    // Iterative solution
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {

            ListNode nextOfNext = next.next;

            // Reverse the pointer
            next.next = cur;

            // Move to the next
            cur = next;
            next = nextOfNext;
        }

        // Remove the next pointer from the head
        head.next = null;

        return cur;
    }

    // Recursive solution
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//
//        }
//        return this.reverseList(head, null);
//    }
//
//    public ListNode reverseList(ListNode current, ListNode previous) {
//        if (current.next == null) {
//            current.next = previous;
//            return current;
//        }
//        else {
//
//            ListNode nextTmp = current.next;
//            current.next = previous;
//            return reverseList(nextTmp, current);
//        }
//    }

}
