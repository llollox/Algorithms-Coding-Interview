package previmedical.it.leetcode.problems.crack.treegraph;

import previmedical.it.leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepths {

    /*

        Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
        (e.g., if you have a tree with depth D, you'll have D linked lists).

        Solution.

        Faccio una bfs
        Salvo il puntatore all'ultimo nodo di ogni livello.
        Quando poppo un elemento dalla coda ed è l'ultimo del livello,
        prima di pushare dentro i suoi figli creo una lista col contenuto corrente della coda.

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
