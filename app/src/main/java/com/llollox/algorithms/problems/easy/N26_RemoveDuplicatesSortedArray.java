package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N26_RemoveDuplicatesSortedArray {


    // Given a sorted array nums, remove the duplicates in-place such that each element
    // appear only once and return the new length.
    // Do not allocate extra space for another array,
    // you must do this by modifying the input array in-place with O(1) extra memory.

    /*

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }

     */

    // idx posizione dell'array fino dove non ho duplicati

    //         idx
    // [0,1,2,3,4,2,2,3,3,4]
    //                i

    // se idx < i =>
    //      idx++
    //      idx = i

    // se idx == i => devo andare avanti con i.

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int index = 0;

        for (int i=1; i<nums.length; i++) {
            if (nums[index] < nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }

    public void test() {
        int[] array = {0,0,1,1,1,2,2,3,3,4};

        int length = removeDuplicates(array);
        Log.w("TEST", "" + length);
    }

}
