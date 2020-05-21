package com.llollox.algorithms.problems.crack.treegraph;

public class BstSuccessor {

    public static class BstNode {
        int v;
        BstNode parent;
        BstNode left;
        BstNode right;

        public BstNode(int v, BstNode parent, BstNode left, BstNode right) {
            this.v = v;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public BstNode successor(BstNode node) {
        if (node.right != null) {
            return dfsLeft(node.right);
        } else {
            return firstParentWhereIAmLeftNode(node);
        }
    }

    private BstNode firstParentWhereIAmLeftNode(BstNode node) {
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        if (node.parent == null) {
            return null;
        } else {
            return node.parent;
        }
    }

    private BstNode dfsLeft(BstNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
