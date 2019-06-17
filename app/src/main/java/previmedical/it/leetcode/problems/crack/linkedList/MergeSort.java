package previmedical.it.leetcode.problems.crack.linkedList;

import previmedical.it.leetcode.models.ListNode;

public class MergeSort {


    public ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = this.getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        middle.next = null; // Split lists

        ListNode left = this.mergeSort(head);
        ListNode right = this.mergeSort(nextOfMiddle);

        return this.merge(left, right);
    }



    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slowRunner = head;
        ListNode fastRunner = head.next;

        while (fastRunner != null) {
            fastRunner = fastRunner.next;

            if (fastRunner != null) {
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }

        // At this point slow runner is in the middle of the list
        return slowRunner;
    }

    /*
        Scorro fintanto che node1 e node2 non sono entrambi null (Sono arrivato alla fine delle liste)
        Se uno tra le due liste e' null allora prendo semplicemente come minimo l'altro valore.
        Setto come successore di current il minimo tra i due e vado avanti.

     */
    private ListNode merge(ListNode node1, ListNode node2) {

        if (node1 == null) {
            return node2;
        }
        else if (node2 == null) {
            return node1;
        }

        ListNode result;

        if (node1.val < node2.val) {
            result = node1;
            result.next = this.merge(node1.next, node2);
        }
        else {
            result = node2;
            result.next = this.merge(node1, node2.next);
        }

        return result;
    }
}
