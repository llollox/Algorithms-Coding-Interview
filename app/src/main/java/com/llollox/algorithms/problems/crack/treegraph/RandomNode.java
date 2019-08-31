package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.Random;

public class RandomNode {

    /*
        You are implementing a binary search tree class from scratch, which, in addition to insert, find, and delete,
        has a method getRandomNode() which returns a random node from the tree.
        All nodes should be equally likely to be chosen.
        Design and implement an algorithm for getRandomNode,
        and explain how you would implement the rest of the methods.
     */


    public TreeNode randomNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        int numNodes = this.getNumNodes(node);

        if (this.randomNumber(1, numNodes) == 1) {
            return node;
        }
        else {
            if (this.randomNumber(0, 1) == 0) {
                return this.randomNode(node.left);
            }
            else {
                return this.randomNode(node.right);
            }
        }
    }


    private int randomNumber(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }


    private int getNumNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getNumNodes(node.left);
        int right = getNumNodes(node.right);

        return left + right + 1;
    }
}
