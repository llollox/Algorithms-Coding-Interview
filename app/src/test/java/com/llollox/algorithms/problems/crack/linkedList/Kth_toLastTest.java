package com.llollox.algorithms.problems.crack.linkedList;

import com.llollox.algorithms.models.ListNode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Kth_toLastTest {

    private Kth_toLast kth_toLast = new Kth_toLast();

    @Test
    public void kthToLast() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        Assert.assertEquals(head, kth_toLast.kthToLast(head, 3));
        Assert.assertEquals(head.next.next, kth_toLast.kthToLast(head, 1));
        Assert.assertEquals(null, kth_toLast.kthToLast(head, 8));
    }

    @Test
    public void kthToLastRecursive() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        Assert.assertEquals(head, kth_toLast.kthToLastRecursive(head, 3));
        Assert.assertEquals(head.next.next, kth_toLast.kthToLastRecursive(head, 1));
        Assert.assertEquals(null, kth_toLast.kthToLastRecursive(head, 8));
    }
}
