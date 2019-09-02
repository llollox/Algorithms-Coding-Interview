package com.llollox.algorithms.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N90_Subsets2 {

    /*
        Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:

        Input: [1,2,2]
        Output:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ]


        Se prendo 2[1] allora devo prendere 2[2] per fare 22
        Se non prendo 2[1] allora posso:
            - prendere 2[2] per fare 2
            - non prendere 2[2] per fare ""


        [2, 2, 2]
        // Se ho preso un valore ed il successivo è uguale, allora lo devo prendere

        se prendo 2[0] allora devo prendere 2[1]:
            prendo 2[1]: devo prendere 2[2]:        222

        se non prendo 2[0]:
            - posso prendere 2[1]:
                devo prendere 2[2]:                 22
            - posso non prendere 2[1]
                - posso prendere 2[2]               2
                - posso non prendere 2[2]           ""


     */



    public List<List<Integer>> subSets(int[] array) {
        ArrayList<List<Integer>> results = new ArrayList<>();

        if (array == null || array.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(array);

        subSets(array, 0, false, new ArrayList<Integer>(), results);

        return results;
    }

    private void subSets(int[] array, int index, boolean mustBeTaken, ArrayList<Integer> recursion, ArrayList<List<Integer>> results) {
        if (index == array.length) {
            ArrayList<Integer> result = new ArrayList<>(recursion);
            results.add(result);
            return;
        }

        // Take the value
        int val = array[index];
        recursion.add(val);
        subSets(array, index + 1, index < array.length - 1 && array[index + 1] == val, recursion, results);
        recursion.remove(recursion.size() - 1);

        // Don't take it
        if (!mustBeTaken) {
            subSets(array, index + 1, false, recursion, results);
        }
    }

}
