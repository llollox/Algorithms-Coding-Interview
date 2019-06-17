package previmedical.it.leetcode.problems.crack.linkedList;

import previmedical.it.leetcode.models.ListNode;

public class Kth_toLast {


    public ListNode kthToLast(ListNode head, int kToLast)  {

        ListNode slowRunner = head;
        ListNode fastRunner = head;

        for (int i=0; i<kToLast; i++) {
            fastRunner = fastRunner.next;
        }

        while (fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }
}
