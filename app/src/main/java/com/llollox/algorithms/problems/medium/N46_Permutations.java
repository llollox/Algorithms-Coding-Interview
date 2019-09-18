package com.llollox.algorithms.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class N46_Permutations {

    /*
    Given a collection of distinct integers, return all possible permutations.

    Example:

    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
     */


    /*
        Note
        - Does the array fit in memory? Yes
        - What if the array is null or empty? Return an empty array
        - The array cannot contain duplicates
     */

    /*
        Approach 1 Time O(n!) Space O((n + 1)!)
        - Instantiate an array list of results
        - Instantiate a LinkedHashSet of the indexes of choosen elements

        - If the set has the same size of the array
            - Insert the content of the set into the results list
        - For each element in the array that its index is not contained into the set:
            - Add the index of the chosen element to the hashset and continue
            - Call recursively
            - Remove the index from the linked hash set
     */

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        permute(results, set, nums);
        return results;
    }

    private void permute(ArrayList<List<Integer>> results, LinkedHashSet<Integer> chosenIndexes, int[] nums) {
        if (chosenIndexes.size() == nums.length) {
            results.add(toValues(chosenIndexes, nums));
        }
        else {
            for (int i=0; i<nums.length; i++) {
                if (!chosenIndexes.contains(i)) {
                    chosenIndexes.add(i);
                    permute(results, chosenIndexes, nums);
                    chosenIndexes.remove(i);
                }
            }
        }
    }

    private ArrayList<Integer> toValues(LinkedHashSet<Integer> chosenIndexes, int[] nums) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int index : chosenIndexes) {
            results.add(nums[index]);
        }
        return results;
    }


    /*
        Approach 2 Time O(n!) Space O((n + 1)!)
        - Instantiate an array list of results
        - Start with an index = 0
        - If index == nums.length
            - Add a copy of the array into the results
        - For all elements after from index included (I consider them to be chosen):
            - Swap that element at position index
            - Call recursively with index + 1
            - Reswap back that item to its previous position
     */

    public List<List<Integer>> permuteOptmial(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }


        permuteOptmial(results, nums, 0);
        return results;
    }

    private void permuteOptmial(ArrayList<List<Integer>> results, int[] nums, int index) {
        if (index == nums.length) {
            results.add(toList(nums));
        }
        else {
            for (int i=index; i<nums.length; i++) {
                this.swap(nums, i, index);
                permuteOptmial(results, nums, index + 1);
                this.swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private ArrayList<Integer> toList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int v: nums) {
            list.add(v);
        }
        return list;
    }
}
