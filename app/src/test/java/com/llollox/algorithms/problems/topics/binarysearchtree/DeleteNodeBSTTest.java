package com.llollox.algorithms.problems.topics.binarysearchtree;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteNodeBSTTest {

    DeleteNodeBST deleteNodeBST = new DeleteNodeBST();

    @Test
    public void deleteLeaf() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(5);

        deleteNodeBST.delete(node, 5);

        Assert.assertNull(node.right);
    }

    @Test
    public void deleteNodeOneChild() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(8);

        deleteNodeBST.delete(node, 3);

        Assert.assertEquals(1, node.left.val);
    }

    @Test
    public void deleteNodeTwoChildren() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(8);

        deleteNodeBST.delete(node, 3);

        Assert.assertEquals(4, node.left.val);
        Assert.assertEquals(1, node.left.left.val);
    }
}