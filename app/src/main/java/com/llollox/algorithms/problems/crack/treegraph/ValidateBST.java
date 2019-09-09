package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

public class ValidateBST {

    /*
        Implement a function to check if a binary tree is a binary search tree.

        Fit in memory? Yes
        What if the given binary tree is null? Return true

                   5
               3        100
          1      4   4      101

        Approach 1 Time O(n) Space O(n)
        - Fare una DFS in visita creando un array
        - Verificare che l’array sia ordinato correttamente

        Approach 2 Time O(n) Space O(log n)
        - Visitare tutti i nodi con una dfs verificando che ogni nodo sia nell'intervallo min, max
         - Quando vado al mio figlio SX passo min = min e max = me stesso
         - Quando vado al mio figlio DX passo min = me stesso e max = max

     */

    public boolean checkBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        return checkBSTNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBSTNode(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (min <= node.val && node.val <= max) {
            return checkBSTNode(node.left, min, node.val) && checkBSTNode(node.right, node.val, max);
        }
        else {
            return false;
        }
    }
}
