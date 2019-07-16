package previmedical.it.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;
import previmedical.it.leetcode.models.ListNode;
import previmedical.it.leetcode.problems.medium.N24_SwapNodesInPairs;

public class N24Tests {

    @Test
    public void test1() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        N24_SwapNodesInPairs n24 = new N24_SwapNodesInPairs();

        ListNode output = n24.swapNodeInPairs(l1);
        Assert.assertEquals(2, output.val);
    }
}
