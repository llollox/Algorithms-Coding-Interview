package com.llollox.algorithms.problems.crack.treegraph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BstSuccessorTest {

    private BstSuccessor successor = new BstSuccessor();

    @Test
    public void successor() {
        BstSuccessor.BstNode node = new BstSuccessor.BstNode(4, null, null, null);
        node.right = new BstSuccessor.BstNode(10, node, null, null);
        node.right.right = new BstSuccessor.BstNode(100, node.right, null, null);
        node.right.left = new BstSuccessor.BstNode(8, node.right, null, null);
        node.right.left.left = new BstSuccessor.BstNode(7, node.right.left, null, null);
        node.right.left.right = new BstSuccessor.BstNode(9, node.right.left, null, null);

        Assert.assertEquals(7, successor.successor(node).v);
        Assert.assertEquals(8, successor.successor(node.right.left.left).v);
        Assert.assertEquals(10, successor.successor(node.right.left.right).v);
        assertNull(successor.successor(node.right.right));
    }
}
