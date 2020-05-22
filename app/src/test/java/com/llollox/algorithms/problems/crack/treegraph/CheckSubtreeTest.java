package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

public class CheckSubtreeTest {

    private CheckSubtree checkSubtree = new CheckSubtree();


    @Test
    public void assertTrue() {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(15);
        head.right = new TreeNode(30);
        head.right.left = new TreeNode(28);
        head.right.right = new TreeNode(35);

        TreeNode t2 = new TreeNode(30);
        t2.left = new TreeNode(28);
        t2.right = new TreeNode(35);

        Assert.assertTrue(checkSubtree.checkSubTree(head, t2));
    }

    @Test
    public void assertFalse() {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(15);
        head.right = new TreeNode(30);
        head.right.left = new TreeNode(28);
        head.right.right = new TreeNode(35);


        TreeNode t2 = new TreeNode(30);
        t2.left = new TreeNode(28);

        Assert.assertFalse(checkSubtree.checkSubTree(head, t2));
    }

    @Test
    public void assertSimpleTrue() {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(15);
        head.right = new TreeNode(30);
        head.right.left = new TreeNode(28);
        head.right.right = new TreeNode(35);

        TreeNode t2 = new TreeNode(30);
        t2.left = new TreeNode(28);
        t2.right = new TreeNode(35);

        Assert.assertTrue(checkSubtree.checkSubtreeSimple(head, t2));
    }

    @Test
    public void assertSimpleFalse() {
        TreeNode head = new TreeNode(20);
        head.left = new TreeNode(10);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(15);
        head.right = new TreeNode(30);
        head.right.left = new TreeNode(28);
        head.right.right = new TreeNode(35);


        TreeNode t2 = new TreeNode(30);
        t2.left = new TreeNode(28);

        Assert.assertFalse(checkSubtree.checkSubtreeSimple(head, t2));
    }

}