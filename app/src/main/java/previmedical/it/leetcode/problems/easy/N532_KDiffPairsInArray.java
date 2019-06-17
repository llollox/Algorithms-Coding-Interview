package previmedical.it.leetcode.problems.easy;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;

public class N532_KDiffPairsInArray {

    // Given an array of integers and an integer k,
    // you need to find the number of unique k-diff pairs in the array.
    // Here a k-diff pair is defined as an integer pair (i, j),
    // where i and j are both numbers in the array and their absolute difference is k.

    // Example 1
    // Input: [3, 1, 4, 1, 5], k = 2
    // Output: 2
    // Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    // Although we have two 1s in the input, we should only return the number of unique pairs.

    // Example 2
    // Input:[1, 2, 3, 4, 5], k = 1
    // Output: 4
    // Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

    // Example 3
    // Input: [1, 3, 1, 5, 4], k = 0
    // Output: 1
    // Explanation: There is one 0-diff pair in the array, (1, 1).

    // [3, 1, 4, 1, 5], k = 2
    // [1, 1, 3, 4, 5], k = 2

    public int findPairs(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int counter = 0;
        Integer previous = null;

        for (int i=0; i<nums.length - 1; i++) {

            if (previous != null && previous == nums[i]) {
                continue;
            }

            int j = i + 1;

            while (j < nums.length && Math.abs(nums[j] - nums[i]) <= k) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    counter++;
                    break;
                }
                j++;
            }

            previous = nums[i];
        }

        return counter;
    }

    public void test() {
        int[] input = {3, 1, 4, 1, 5};
        int k = 2;

        int output = this.findPairs(input, k);
        Log.w("TEST", "" + output);
    }
}
