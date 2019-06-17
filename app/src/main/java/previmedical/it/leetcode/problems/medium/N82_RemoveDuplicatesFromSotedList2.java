package previmedical.it.leetcode.problems.medium;

import previmedical.it.leetcode.models.ListNode;

public class N82_RemoveDuplicatesFromSotedList2 {

    /*

        Given a sorted linked list, delete all nodes that have duplicate numbers,
        leaving only distinct numbers from the original list.

        Example 1:
        Input: 1->2->3->3->4->4->5
        Output: 1->2->5

        Example 2:
        Input: 1->1->1->2->3
        Output: 2->3

     */

    /*

        Solution.

        Easy solution Time: O(2*n) Space O(n)
        First pass recognize which nodes has duplicates and save them into a set.
        Second pass, delete the node saved into the set.

        Time: O(n) Space O(1)
        Loop through the list.

        In order to delete a node:
            If prev == null
                head = head.next
            else
                prev.next = current.next


        For each node I keep track of the previous node.
        For each node i start a while loop in which I delete the node if they
        has the same value of the current.

        Than, if I entered in the while loop at least once, I delete also the current node.
     */

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        boolean hasDuplicates;


        do {

            // While i prossimi hanno lo stesso valore li elimino.
            // Se sono entrato nel loop almeno 1 volta allora elimino anche me stesso

            hasDuplicates = false;

            // While the next node has the same value of me, I delete it.
            while (current.next != null && current.next.val == current.val) {
                current.next = current.next.next;
                hasDuplicates = true;
            }

            if (hasDuplicates) {
                // Delete also current node

                if (prev == null) { // If it is the head, I need to move it forward
                    head = head.next;
                }
                else {
                    // Delete current node in the middle of the list
                    prev.next = current.next;
                }
            }
            else {
                // Save prev for the next iteration
                prev = current;
            }

            current = current.next;

        } while (current != null && current.next != null);


        return head;
    }
}
