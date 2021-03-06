package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

public class MinimalTree {

    /*
        Given a sorted (increasing order) array with unique integer elements,
        write an algorithm to create a binary search tree with minimal height.


        Solution. T O(n)  S O(1)

        La root dell'albero e' l'elemento in mezzo dell'array.
        Il nodo sinistro è l'elemento in mezzo della metà sinistra,
        il nodo destro è l'elemento in mezzo della metà di destra.

        Cosí ricorsivamente per tutti i livelli successivi.
     */


    public TreeNode minimalTree(int[] array) {
        return minimalTree(array, 0, array.length - 1);
    }

    // start inclusive, end exclusive
    private TreeNode minimalTree(int[] array, int start, int end) {

        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode midNode = new TreeNode(array[mid]);

        midNode.left = this.minimalTree(array, start, mid - 1);
        midNode.right = this.minimalTree(array, mid + 1, end);

        return midNode;
    }
}
