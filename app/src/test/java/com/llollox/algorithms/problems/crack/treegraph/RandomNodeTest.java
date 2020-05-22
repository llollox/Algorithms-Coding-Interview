package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNodeTest {

    private RandomNode randomNode = new RandomNode();

    @Test
    public void getRandomNodeInOrderTraversal() {

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        Assert.assertEquals(4, randomNode.getIthNode(node, new RandomNode.Counter(-1), 0).val);
        Assert.assertEquals(1, randomNode.getIthNode(node, new RandomNode.Counter(-1), 1).val);
        Assert.assertEquals(5, randomNode.getIthNode(node, new RandomNode.Counter(-1), 2).val);
        Assert.assertEquals(2, randomNode.getIthNode(node, new RandomNode.Counter(-1), 3).val);
        Assert.assertEquals(6, randomNode.getIthNode(node, new RandomNode.Counter(-1), 4).val);
        Assert.assertEquals(3, randomNode.getIthNode(node, new RandomNode.Counter(-1), 5).val);
        Assert.assertEquals(7, randomNode.getIthNode(node, new RandomNode.Counter(-1), 6).val);
    }
}