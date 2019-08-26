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

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }


    public boolean checkBalancedImproved(TreeNode node) {
        if (node == null) {
            return true;
        }

        return checkBalancedDFS(node) != -1;

    }

    private int checkBalancedDFS(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalancedDFS(node.left);
        int rightHeight = checkBalancedDFS(node.right);

        if (leftHeight == -1                                    // Unbalanced left
                || rightHeight == -1                            // Unbalanced right
                || Math.abs(leftHeight - rightHeight) >= 2) {   // Unbalanced current node
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
