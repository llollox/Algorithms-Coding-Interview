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

    private ArrayList<ArrayList<Integer>> bstSequence(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> elements = new ArrayList<>();
            for (TreeNode node : queue) {
                elements.add(node.val);
            }

            ArrayList<ArrayList<Integer>> permutations = getPermutations(elements);
            for (ArrayList<Integer> result : results) {

                for (ArrayList<Integer> permutation : permutations) {

//                    result.addAll(permutation);
                }
            }
        }
    }


    private ArrayList<ArrayList<Integer>> getPermutations(List<Integer> list) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        getPermutations(results, new ArrayList<Integer>(), new HashSet<>(list));
        return results;
    }

    private void getPermutations(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> current, HashSet<Integer> remaining) {
        if (remaining.isEmpty()) {
            results.add(current);
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
