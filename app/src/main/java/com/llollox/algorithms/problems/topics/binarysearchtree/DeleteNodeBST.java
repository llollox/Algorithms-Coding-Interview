package com.llollox.algorithms.problems.topics.binarysearchtree;

import com.llollox.algorithms.models.TreeNode;

public class DeleteNodeBST {

    /*
        I want to delete a node from a BST. Approach:
        - Se il nodo è una foglia -> lo posso eliminare direttamente
        - Se il nodo ha un figlio solo, sostituisco me stesso con mio figlio
        - Se il nodo ha due figli:
            - Cerco il successore di me stesso.
            - Setto il mio valore a quello del mio successore
            - Mi occupo ricorsivamente di cancellare il nodo del mio successore.
     */

    public TreeNode delete(TreeNode node, int value) {
        /* Base Case: If the tree is empty */
        if (node == null) return null;

        /* Otherwise, recur down the tree */
        if (value < node.val)
            node.left = delete(node.left, value);
        else if (value > node.val)
            node.right = delete(node.right, value);
        else {
            // if key is same as root's key, then This is the node to be deleted

            // node with only one child or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            TreeNode successor = getLeftMostChild(node.right);
            node.val = successor.val;

            // Delete the inorder successor
            node.right = delete(node.right, successor.val);
        }

        return node;
    }

    private TreeNode getLeftMostChild(TreeNode node) {
        if (node == null) {
            return null;
        }
        else if (node.left == null) {
            return node;
        }
        else {
            return getLeftMostChild(node.left);
        }
    }
}
