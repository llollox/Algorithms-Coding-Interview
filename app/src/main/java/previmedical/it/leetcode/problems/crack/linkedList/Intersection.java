package previmedical.it.leetcode.problems.crack.linkedList;

import previmedical.it.leetcode.models.ListNode;

public class Intersection {

    /*
        Given two (singly) linked lists, determine if the two lists intersect.
        Return the intersecting node.
        Note that the intersection is defined based on reference, not value.
        That is, if the kth node of the first linked list is the exact same node (by reference)
        as the jth node of the second linked list, then they are intersecting.
     */


    /*
        Solution.
        Padding per la lista piu corta, significa che sposto avanti il puntatore della lista piu lunga
        per la differenza di nodi tra la lunga e la corta.
        A questo punto faccio avanzare entrambi i puntatori in sincronia, se si incontrano ritorno
        l'elemento di intersezione.
     */

    public ListNode intersection(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return null;
        }

        int length1 = LinkedListUtil.length(head1);
        int length2 = LinkedListUtil.length(head2);

        if (length1 < length2) {
            for (int i=0; i<length2-length1; i++) {
                head2 = head2.next;
            }
        }
        else {
            for (int i=0; i<length1-length2; i++) {
                head1 = head1.next;
            }
        }

        // At this point both lists must have the same length.

        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
}
