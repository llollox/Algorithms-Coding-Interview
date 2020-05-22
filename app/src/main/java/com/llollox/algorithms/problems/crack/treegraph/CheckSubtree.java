package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

public class CheckSubtree {

    /*
    Tl and T2 are two very large binary trees, withTl much bigger thanT2.
    Create an algorithm to determine ifT2 is a subtree ofTl.
    A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
    That is, if you cut off the tree at node n, the two trees would be identical.
     */

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return false;
        }

        return findNodesWithValueDfs(t1, t2);
    }

    private boolean findNodesWithValueDfs(TreeNode node, TreeNode t2) {
        if (node == null) {
            return false;
        }

        if (node.val == t2.val && checkSameTreeCombinedDfs(node, t2)) {
            return true;
        }

        return findNodesWithValueDfs(node.left, t2) || findNodesWithValueDfs(node.right, t2);
    }

    private boolean checkSameTreeCombinedDfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        return checkSameTreeCombinedDfs(t1.left, t2.left)
                && checkSameTreeCombinedDfs(t1.right, t2.right);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean checkSubtreeSimple(TreeNode t1, TreeNode t2) {
        if (t2 == null) { return false; }

        StringBuilder t1Sb = new StringBuilder();
        StringBuilder t2Sb = new StringBuilder();

        getPreOrderVisitString(t1, t1Sb);
        getPreOrderVisitString(t2, t2Sb);

        return t1Sb.toString().contains(t2Sb.toString());
    }

    private void getPreOrderVisitString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('X');
            return;
        }

        sb.append(node.val);
        getPreOrderVisitString(node.left, sb);
        getPreOrderVisitString(node.right, sb);
    }
}
