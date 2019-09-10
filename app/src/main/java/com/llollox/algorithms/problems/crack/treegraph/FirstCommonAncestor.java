package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

public class FirstCommonAncestor {

    /*
        Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
        Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
     */

    /*
        Question
        - Does the tree fit in memory? Yes
        - What if the tree is null or one of the two nodes are null? Return null
        - What if one or both nodes doesn't exists into the tree? Return null
        - Can a node be the ancestor of the other node? Yes
            - Ex. If one of the two nodes is the root of the tree
        - What if n1 and n2 are the same?

        - Approach 1 Time O(n log n) Space O(log n)
            - Scorro l'albero con una DFS
                - Per ogni nodo faccio partire una DFS per cercare se entrambi i nodi sono raggiungibili
                    - Se vedo che i nodi li trovo dal figlio destro
                        - Ricorro solo nel figlio destro
                    - Se vedo che i nodi li trovo dal figlio sinistro
                        - Ricorro solo nel figlio sinistro
                    - Se vedo che uno viene dal mio figlio sinitro e l'altro da quello destro
                        - Ho trovato il nodo che è il primo antenato comune

        - Approach 2 Time O(log n) Space O(log n)  Assumo di avere il puntatore al padre di un nodo
            - Istanzio un HashSet<Node>
            - Parto dal nodo 1 ed inserisco tutti gli antenati fino alla radice
            - Parto dal nodo 2 e per ogni antenato fino alla radice, lo cerco nel set, il primo che trovo lo ritorno.
     */


    public TreeNode firstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || n1 == null || n2 == null) {
            return null;
        }

        if (n1 == n2) {
            return n1;
        }

        return containsDfs(root, n1, n2);
    }

    public TreeNode containsDfs(TreeNode node, TreeNode n1, TreeNode n2) {
        if (node == null) {
            return null;
        }

        if (contains(node.left, n1)) {

            if (contains(node.right, n2)) {
                return node;
            }
            else if (contains(node.left, n2)) {
                return containsDfs(node.left, n1, n2);
            }
        }
        else if (contains(node.right, n1)) {

            if (contains(node.left, n2)) {
                return node;
            }
            else if (contains(node.right, n2)) {
                return containsDfs(node.left, n1, n2);
            }
        }

        return null;
    }

    public boolean contains(TreeNode node, TreeNode n1) {
        if (node == null) {
            return false;
        }
        else if (node.val == n1.val) {
            return true;
        }

        return contains(node.left, n1) || contains(node.right, n1);
    }
}
