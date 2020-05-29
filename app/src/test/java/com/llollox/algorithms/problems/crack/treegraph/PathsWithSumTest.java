package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

public class PathsWithSumTest {

    private PathsWithSum pathsWithSum = new PathsWithSum();

    /*
                1
            2       4
         8    4   -1  9
     */

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

    @Test
    public void pathWithSumOptimal() {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(-1);
        node.right.right = new TreeNode(9);

        Assert.assertEquals(2, pathsWithSum.pathWithSumOptimal(node, 3));
    }

    @Test
    public void pathWithSumOptimal2() {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.left.left = new TreeNode(5);
        node.left.left.left.left.left = new TreeNode(6);
        node.left.left.left.left.left.left = new TreeNode(7);
        node.left.left.left.left.left.left.left = new TreeNode(8);
        node.left.left.left.left.left.left.left.left = new TreeNode(9);
        node.left.left.left.left.left.left.left.left.left = new TreeNode(10);

        Assert.assertEquals(6, pathsWithSum.pathWithSumOptimal(node, 10));
    }
}
