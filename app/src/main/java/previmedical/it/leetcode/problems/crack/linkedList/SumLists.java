package previmedical.it.leetcode.problems.crack.linkedList;

import previmedical.it.leetcode.models.ListNode;

public class SumLists {


    /*
        Looppo fintanto che n1 ed n2 sono diversi da null.
        Se uno dei due valori e' null allora ha valore 0
        Setto come valore della lista la somma dei due valori + il carry.
        Ritorno la lista cosi costruita

        T O(n), S O(1)
     */
    public ListNode sumListsReversed(ListNode n1, ListNode n2) {

        ListNode startResult = null;
        ListNode result = null;

        int carry = 0;

        while (n1 != null || n2 != null) {

            int n1val = n1 == null ? 0 : n1.val;
            int n2val = n2 == null ? 0 : n2.val;

            int sum = n1val + n2val + carry;

            ListNode resultNode = new ListNode(sum % 10);

            if (startResult == null) {
                result = resultNode;
                startResult = result;
            }
            else {
                result.next = resultNode;
                result = result.next;
            }

            carry = sum / 10;

            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return startResult;

    }


    public ListNode sumListsCorrectOrder(ListNode n1, ListNode n2) {
        Reverse reverse = new Reverse();

        ListNode summed = this.sumListsReversed(reverse.reverse(n1), reverse.reverse(n2));

        return reverse.reverse(summed);
    }

}
