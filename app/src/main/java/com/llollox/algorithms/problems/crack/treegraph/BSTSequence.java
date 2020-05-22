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
}
