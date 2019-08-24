package previmedical.it.leetcode.problems.crack.hard;

public class MajorityElement {

    /*
        A majority element is an element that makes up more than half of the items in an array.
        Given a positive integers array, find the majority element.
        If there is no majority element, return -1.
        Do this in O(N) time and 0(1) space.

     */

    // NAIVE Time O(N^2) Space O(1) ***************************************************************************
    public int majorityElementNaive(int[] array) {
        for (int v : array) {
            if (isValid(array, v)) {
                return v;
            }
        }

        return -1;
    }

    private boolean isValid(int[] array, int value) {
        int count = 0;
        for (int v : array) {
            if (v == value) {
                count += 1;
            }
        }
        return count > array.length / 2;
    }


    // OPTIMAL Time O(N) Space O(1) ****************************************************************************
    public int majorityElement(int[] array) {
        if (array == null) {
            return -1;
        }

        int majority = 0;
        int count = 0;

        for (int v : array) {
            if (count == 0) {
                majority = v;
            }

            if (v == majority) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }

        return isValid(array, majority) ? majority : -1;
    }
}
