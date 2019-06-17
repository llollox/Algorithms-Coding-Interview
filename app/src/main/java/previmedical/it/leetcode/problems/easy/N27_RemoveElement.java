package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N27_RemoveElement {

    /*
       Given an array nums and a value val,
       remove all instances of that value in-place and return the new length.
       Do not allocate extra space for another array,
       you must do this by modifying the input array in-place with O(1) extra memory.
       The order of elements can be changed. It doesn't matter what you leave beyond the new length.

       Given nums = [3,2,2,3], val = 3,
       Your function should return length = 2, with the first two elements of nums being 2.
       It doesn't matter what you leave beyond the returned length.

       Given nums = [0,1,2,2,3,0,4,2], val = 2,
       Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
       Note that the order of those five elements can be arbitrary.
       It doesn't matter what values are set beyond the returned length.
     */


    //           idx
    // [0,1,3,0,4,0,4,2]  2
    //                i

    //  se nums[i] == 2
    //      i++

    //  se nums[i] != 2
    //      nums[idx] = nums[i]
    //      idx++
    //      i++

    public int removeElement(int[] nums, int val) {

        int index = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public void test() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int output = removeElement(nums, val);
        Log.w("TEST", "" + output);
    }
}
