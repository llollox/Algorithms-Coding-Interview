package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;


public class ListOfDepths {

    /*

        Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
        (e.g., if you have a tree with depth D, you'll have D linked lists).

        Solution.

        Se ricevo null ritorno lista vuota
        Faccio una bfs modificata
        Ad ogni iterazione copio l'intero contenuto della coda in una linked list perchè sono tutti i nodi di quel livello.
        Cancello la coda
        Per ogni elemento dell'ultima lista (quella che ho appena aggiunto) vado ad aggiungere tutti i nodi dei figli
        Ripeto fintanto che ci sono nodi nella coda.
     */


    public ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            result.add(new LinkedList<>(queue));

            queue.clear();

            for (TreeNode node : result.get(result.size() - 1)) {

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }


        return result;
    }
}
