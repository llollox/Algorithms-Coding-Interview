package com.llollox.algorithms.problems.easy;

import android.util.Log;
import com.llollox.algorithms.models.TreeNode;

public class N530_MinimumAbsoluteDistanceInBST {

    // Given a binary search tree with non-negative values,
    // find the minimum absolute difference between values of any two nodes.
    // Note: There are at least two nodes in this BST.
    /*

                     8

               5          12


           3       7            20


        2    4               19





        1

              3

           2

     */

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }
        else {

            int difference = Integer.MAX_VALUE;

            if (root.left != null) {
                TreeNode maxOfLessers = this.maximum(root.left);
                difference = Math.abs(root.val - maxOfLessers.val);
            }

            if (root.right != null) {
                TreeNode minOfGreaters = this.minimum(root.right);
                int diff = Math.abs(root.val - minOfGreaters.val);
                if (diff < difference) {
                    difference = diff;
                }
            }


            difference = Math.min(difference, this.getMinimumDifference(root.left));
            difference = Math.min(difference, this.getMinimumDifference(root.right));

            return difference;
        }
    }

    private TreeNode maximum(TreeNode t) {
        if (t.right == null) {
            return t;
        }
        else {
            return maximum(t.right);
        }
    }

    private TreeNode minimum(TreeNode t) {
        if (t.left == null) {
            return t;
        }
        else {
            return minimum(t.left);
        }
    }

    public void test() {

        TreeNode t = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(2);
        t.right = r;

        int output = this.getMinimumDifference(t);
        Log.w("TEST", "" + output);
    }
}
