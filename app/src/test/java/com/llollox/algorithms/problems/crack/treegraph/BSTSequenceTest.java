package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BSTSequenceTest {

    private BSTSequence bstSequence = new BSTSequence();

    @Test
    public void bstSequenceTest1() {

        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n2.left = n1;
        n2.right = n3;

        List<List<Integer>> output = bstSequence.bstSequenceDfs(n2);

        Assert.assertEquals(2, output.size());
        Assert.assertEquals(Arrays.asList(2, 1, 3), output.get(0));
        Assert.assertEquals(Arrays.asList(2, 3, 1), output.get(1));
    }

}