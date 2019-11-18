package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

public class SumLists {

    /*
        You have two numbers represented by a linked list, where each node contains a single digit.
        The digits are stored in reverse order, such that the 1's digit is at the head of the list.
        Write a function that adds the two numbers and returns the sum as a linked list.

        EXAMPLE
        Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output: 2 -> 1 -> 9.That is, 912.

        FOLLOW UP
        Suppose the digits are stored in forward order.
        Repeat the above problem.
        Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output: 9 ->1 ->2. That is,912.
     */

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


    class PartialSum {
        ListNode node;
        int carry;

        public PartialSum(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }

    public ListNode calculateSumCorrectOrder(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        int diff = Math.abs(l1Length - l2Length);
        ListNode shorter = l1Length > l2Length ? l2 : l1;
        ListNode longer = l1Length > l2Length ? l1 : l2;

        // Padding to shorter linked list
        for (int i=0; i<diff; i++) {
            shorter = prepend(shorter, 0);
        }

        PartialSum partialSum = sum(longer, shorter);
        if (partialSum.carry > 0) {
            return prepend(partialSum.node, partialSum.carry);
        }
        else {
            return partialSum.node;
        }
    }

    private PartialSum sum(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            int sum = l1.val + l2.val;
            int val = sum % 10;
            int carry = sum >= 10 ? 1 : 0;
            return new PartialSum(new ListNode(val), carry);
        }
        else {
            PartialSum prevSum = sum(l1.next, l2.next);
            int sum = l1.val + l2.val + prevSum.carry;
            int val = sum % 10;
            ListNode pre = prepend(prevSum.node, val);
            int carry = sum >= 10 ? 1 : 0;
            return new PartialSum(pre, carry);
        }
    }

    private int getLength(ListNode l) {
        int count = 0;
        ListNode runner = l;
        while (runner != null) {
            runner = runner.next;
            count += 1;
        }

        return count;
    }

    private ListNode prepend(ListNode n, int value) {
        ListNode pre = new ListNode(value);
        pre.next = n;
        return pre;
    }


}
