package previmedical.it.leetcode.problems.easy;

import previmedical.it.leetcode.models.ListNode;

public class N83_RemoveDuplicatesFromSortedList {

    /*

        Given a sorted linked list, delete all duplicates such that each element appear only once.

        Example 1:
        Input: 1->1->2
        Output: 1->2

        Example 2:
        Input: 1->1->2->3->3
        Output: 1->2->3

     */

    /*

        Solution. O(n)

        Starting from the head.
        I save the previous value.

        If I found that the previous value is the same as me,
        than I delete myself and go to next.

        Otherwise I go to the next element and update the previous value.

     */

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode node = head;

        while (node.next != null) {
            node = node.next;
            if (prev.val == node.val) {
                prev.next = node.next;
            }
            else {
                prev = node;
            }
        }

        return head;
    }
}
