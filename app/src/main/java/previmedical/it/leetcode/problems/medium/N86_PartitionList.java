package previmedical.it.leetcode.problems.medium;

import android.util.Log;
import previmedical.it.leetcode.models.ListNode;

public class N86_PartitionList {


    // Given a linked list and a value x,
    // Partition it such that all nodes less than x come before nodes greater than or equal to x.
    // You should preserve the original relative order of the nodes in each of the two partitions.

    /*
        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5
     */

    // scorro la lista fino alla fine.
    // se node.val < 3
    //    vado avanti

    // se invece node.val >= 3

        // accodo il nodo alla lista di quelli piu grandi
        // greaters.next = node

        // cancello il nodo
        // node.val = node.next.val
        // node.next = node.next.next

    // alla fine mergio le liste
        // list.next = greaters



    public ListNode partition(ListNode head, int x) {

        ListNode headSmallers = null;
        ListNode tailSmallers = null;
        ListNode headGreaters = null;
        ListNode tailGreaters = null;

        while (head != null) {

            if (head.val < x) {

                if (headSmallers == null) {
                    headSmallers = head;
                    tailSmallers = head;
                }
                else {
                    tailSmallers.next = head;
                    tailSmallers = head;
                }

                head = head.next;
            }
            else {
                int nodeVal = head.val;
                ListNode nextNode = head.next;

                if (nextNode != null) {
                    // Cancello il nodo dalla lista di quelli piu piccoli
                    head.val = nextNode.val;
                    head.next = nextNode.next;

                    nextNode.val = nodeVal;
                    nextNode.next = null; // Elimino il riferimento al prossimo
                }
                else {
                    if (tailSmallers != null) {
                        tailSmallers.next = null;
                    }
                    nextNode = head;
                    head = head.next;
                }

                // Accodo il nodo ai greaters
                if (headGreaters == null) {
                    headGreaters = nextNode;
                    tailGreaters = nextNode;
                }
                else {
                    tailGreaters.next = nextNode;
                    tailGreaters = nextNode;
                }
            }
        }

        if (tailSmallers != null) {
            tailSmallers.next = headGreaters;
            return headSmallers;
        }
        else {
            return headGreaters;
        }
    }


    public void test() {

        //  head = 1->4->3->2->5->2, x = 3
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);

        ListNode output = this.partition(l, 3);

        Log.w("TEST", output.toString());
    }
}
