package previmedical.it.leetcode.problems.crack.treegraph;

import previmedical.it.leetcode.models.TreeNode;

public class CheckBalanced {

    /*
         Implement a function to check if a binary tree is balanced.
         For the purposes of this question, a balanced tree is defined to be a tree such that the
         heights of the two subtrees of any node never differ by more than one.
     */


    public boolean checkBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = this.getHeight(root.left);
        int rightHeight = this.getHeight(root.right);

        int diff = Math.abs(leftHeight - rightHeight);

        return diff <= 1 && (checkBalanced(root.left) && checkBalanced(root.right));
    }

    public boolean checkBalancedImproved(TreeNode node) {
        return this.checkHeight(node) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = this.checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = this.checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        if (Math.abs(rightHeight - leftHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }
}
