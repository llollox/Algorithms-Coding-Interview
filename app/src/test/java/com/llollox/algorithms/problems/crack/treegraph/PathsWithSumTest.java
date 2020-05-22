package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

public class PathsWithSumTest {

    private PathsWithSum pathsWithSum = new PathsWithSum();

    @Test
    public void pathWithSumReImplemented() {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(-1);
        node.right.right = new TreeNode(9);

        Assert.assertEquals(2, pathsWithSum.pathWithSumReImplemented(node, 3));
    }
}