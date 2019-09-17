package com.llollox.algorithms.problems.medium;

import java.util.Arrays;
import java.util.TreeMap;

public class N31_NextPermutation {

    /*
    Implement next permutation,
    which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible,
    it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place and use only constant extra memory.

    Here are some examples.
    Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

    1,2,3 → 1,3,2
    1,3,2 → 2,1,3
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

     */


    /*
        Note
        - What if the array doesn't fit in memory? it fits
        - What if the array is null or empty or with one value?
            There is nothing to rearrange, returns the array


        Approach 1 Time O(n!) Space O(n)
        - If items are in a descending order
            - Sort the array
        - Generate all permutations of the array
        - Keep the minimum permutation that is greater than current one.

        Approach 2 O(n log n) Space O(1)
        - let define index = the index of the first element in which the previous number is less than the current one O(n)
            - if there is no the case, sort the array and return it
        - Find the minimum value that is greater than the element of index - 1 (the smaller element)
        - Swap the item at index - 1 with the smallest greater
        - Sort the sub array starting from position index
     */

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return; // nothing to do
        }

        int index = nums.length - 1;

        while (index > 0 && nums[index - 1] >= nums[index]) {
            index -= 1;
        }

        if (index == 0) {
            Arrays.sort(nums);
            return;
        }

        int minGreaterIndex = index;
        for (int i=index; i<nums.length; i++) {
            int value = nums[i];
            if (nums[minGreaterIndex] > value && value > nums[index - 1]) {
                minGreaterIndex = i;
            }
        }

        this.swap(nums, minGreaterIndex, index - 1);

        Arrays.sort(nums, index, nums.length);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
