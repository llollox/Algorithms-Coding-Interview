package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTSequence {

    /*
         A binary search tree was created by traversing through an array from left to right and inserting each element.
         Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.


            2
          1   3

         [2, 1]
         [2, 3]

         [2, 1, 3]  [2, 3, 1]

             5
          3     8
        1   4  6  9

        [5, 3, 8, 1, 4, 6, 9]
        [5, 8, 3, 1, 4, 6, 9]
     */

    /*
        - Questions:
            - Does it fit in memory? Yes
            - What if the tree is null? Return empty list
            - Can I assume that the given tree is always a binary search tree? Yes


        App 1 Time O(n) Space O(n!)
           - Instantiate a ArrayList of List<Integer> as result
           - Traverse the tree with a DFS. For each element
            - if it is null return with a list with an empty list contained
            - otherwise recurse on both child
            - waves both lists and create all the combinations
                - take all combinations of two lists
                - taken two lists of integers, return all the combination of lists keeping the order of both lists.
            - prepend me to all the waved lists
     */

    /*
        2
      1   3
     */

    public ArrayList<ArrayList<Integer>> bstSequence(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> leftLists = bstSequence(root.left);
        ArrayList<ArrayList<Integer>> rightLists = bstSequence(root.right);

        if (leftLists.isEmpty() && rightLists.isEmpty()) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            results.add(list);
            return results;
        }
        else if (leftLists.isEmpty()) {
            return prepend(rightLists, root.val);
        }
        else if (rightLists.isEmpty()) {
            return prepend(leftLists, root.val);
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (ArrayList<Integer> leftList : leftLists) {
            for (ArrayList<Integer> rightList : rightLists) {
                results.addAll(wave(leftList, rightList));
            }
        }

        return prepend(results, root.val);
    }

    private ArrayList<ArrayList<Integer>> prepend(ArrayList<ArrayList<Integer>> lists, int value) {
        for (ArrayList<Integer> list : lists) {
            list.add(0, value);
        }
        return lists;
    }

    public ArrayList<ArrayList<Integer>> wave(ArrayList<Integer> l1, List<Integer> l2) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        wave(results, l1 , l2, -1, 0);
        return results;
    }

    private void wave(
            ArrayList<ArrayList<Integer>> results,
            ArrayList<Integer> current,
            List<Integer> l2,
            int previousIndex,
            int index) {

        if (index == l2.size()) {
            results.add(current);
            return;
        }

        int value = l2.get(index);

        for (int i = previousIndex + 1; i<= current.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>(current);
            copy.add(i, value);
            wave(results, copy, l2, i, index + 1);
        }
    }

    ///////////////////////////////////////////////////////////////////

    public List<List<Integer>> bstSequenceDfs(TreeNode node) {
        ArrayList<List<Integer>> solutions = new ArrayList<>();

        if (node == null) {
            solutions.add(new ArrayList<Integer>());
        }
        else if (node.left == null && node.right == null) {
            ArrayList<Integer> s = new ArrayList<>();
            s.add(node.val);
            solutions.add(s);
        }
        else {
            List<List<Integer>> leftSequence = bstSequenceDfs(node.left);
            List<List<Integer>> rightSequence = bstSequenceDfs(node.right);

            if (!leftSequence.isEmpty() && !rightSequence.isEmpty()) {
                for (List<Integer> l : leftSequence) {
                    for (List<Integer> r : rightSequence) {
                        solutions.addAll(prefix(wave(l, r), node.val));
                    }
                }
            }
            else if (!leftSequence.isEmpty()) {
                return prefix(leftSequence, node.val);
            }
            else {
                return prefix(rightSequence, node.val);
            }
        }

        return solutions;
    }

    private List<List<Integer>> prefix(List<List<Integer>> lists, int prefix) {
        ArrayList<List<Integer>> solutions = new ArrayList<>();
        for (List<Integer> l : lists) {
            ArrayList<Integer> solution = new ArrayList<>();
            solution.add(prefix);
            solution.addAll(l);
            solutions.add(solution);
        }
        return solutions;
    }

    /*
        Parto con l'idea che devo scegliere l1.length + l2.length elementi
        Ad ogni step posso scegliere se prendere un elemento da l1 o da l2.
        Ho due puntatori (che all'inizio puntano al primo elemento di ogni lista).
        Quando un puntatore raggiunge la fine della lista significa che ho scelto tutti i suoi elementi.

        Ad ogni step provo scegliendo prima un elemento dalla prima lista.
        Riporto indietro il puntatore
        Scelgo un elemento dalla seconda lista ecc.
     */
    private List<List<Integer>> wave(List<Integer> l1, List<Integer> l2) {
        ArrayList<List<Integer>> solutions = new ArrayList<>();
        wave(l1, l2, 0, 0, solutions, new ArrayList<Integer>());
        return solutions;
    }

    private void wave(
            List<Integer> l1, List<Integer> l2,
            int l1index, int l2index,
            ArrayList<List<Integer>> solutions, ArrayList<Integer> solution) {

        if (l1index == l1.size() && l2index == l2.size()) {
            // Ho finito tutti gli elementi a disposizione
            solutions.add(solution);
            return;
        }

        if (l1index < l1.size()) {
            // Provo a prendere l1index
            ArrayList<Integer> copy = new ArrayList<>(solution);
            copy.add(l1.get(l1index));
            wave(l1, l2, l1index + 1, l2index, solutions, copy);
        }

        if (l2index < l2.size()) {
            // Provo a prendere l2index
            ArrayList<Integer> copy = new ArrayList<>(solution);
            copy.add(l2.get(l2index));
            wave(l1, l2, l1index, l2index + 1, solutions, copy);
        }
    }
}
