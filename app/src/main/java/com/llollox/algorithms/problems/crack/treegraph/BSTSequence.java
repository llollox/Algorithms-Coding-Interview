package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.*;

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
           - Insert a list with the root element
           - Traverse the BST with BFS
             - For each level, create all the permutations of the nodes
             - Insert each permutation for each list, duplicating the values
     */

    public ArrayList<ArrayList<Integer>> bstSequence(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());

        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<TreeNode> nodes = new ArrayList<>();

            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }

            ArrayList<Integer> elements = new ArrayList<>();
            for (TreeNode node : nodes) {
                elements.add(node.val);
            }

            results = merge(results, getPermutations(elements));

            for (TreeNode node : nodes) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return results;
    }

    private ArrayList<ArrayList<Integer>> merge(
            ArrayList<ArrayList<Integer>> results,
            ArrayList<ArrayList<Integer>> permutations) {

        ArrayList<ArrayList<Integer>> newResults = new ArrayList<>();

        for (ArrayList<Integer> result : results) {
            for (ArrayList<Integer> permutation : permutations) {
                ArrayList<Integer> r = new ArrayList<>(result);
                r.addAll(permutation);
                newResults.add(r);
            }
        }

        return newResults;
    }


    public ArrayList<ArrayList<Integer>> getPermutations(List<Integer> list) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        getPermutations(results, new ArrayList<Integer>(), new HashSet<>(list));
        return results;
    }

    private void getPermutations(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> current, HashSet<Integer> remaining) {
        if (remaining.isEmpty()) {
            results.add(new ArrayList<>(current));
        }

        for (Integer value : remaining) {
            HashSet<Integer> rem = new HashSet<>();
            rem.addAll(remaining);
            rem.remove(value);

            current.add(value);
            getPermutations(results, current, rem);
            current.remove(value);
        }
    }
}
