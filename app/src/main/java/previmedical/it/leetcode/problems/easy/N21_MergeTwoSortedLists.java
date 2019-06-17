package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N21_MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // It workds in 1ms
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root;

        if (l1.val < l2.val) {
            root = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            root = new ListNode(l2.val);
            l2 = l2.next;
        }

        ListNode merged = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
                merged = merged.next;
            }
            else {
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
                merged = merged.next;
            }
        }

        if (l1 == null) {
            merged.next = l2;
        }
        else {
            merged.next = l1;
        }

        return root;
    }

    // It workds 0 ms
    public ListNode mergeRecursive(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node;

        if (l1.val < l2.val) {
            node = new ListNode(l1.val);
            node.next = mergeRecursive(l1.next, l2);
        }
        else {
            node = new ListNode(l2.val);
            node.next = mergeRecursive(l1, l2.next);
        }

        return node;
    }


    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode merged = mergeRecursive(l1, l2);
        Log.w("TEST", merged.toString());
    }
}
