package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N53_MaximumSubArray {

    /*

    Given an integer array nums, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum.

    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6

    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:
    If you have figured out the O(n) solution,
    try coding another solution using the divide and conquer approach, which is more subtle.
     */


    /*


     */

    public int maxSubArray(int[] nums) {

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i=0; i<nums.length; i++) {
            maxEndingHere = maxEndingHere + nums[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public int maxSubArrayDivideEtConquer(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else {
            return this.maxSubArraySum(nums, 0, nums.length - 1);
        }
    }

    public int maxSubArraySum(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        else {

            int mid = (start + end) / 2;

            return Math.max(Math.max(
                    this.maxSubArraySum(nums, start, mid),
                    this.maxSubArraySum(nums, mid + 1, end)),
                    this.maxCrossingSum(nums, start, mid, end));
        }
    }

    // La somma massima nell'intorno del numero mid
    public int maxCrossingSum(int[] nums, int start, int mid, int end) {

        int maxLeftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=mid; i >= start; i--) {
            sum = sum + nums[i];

            if (sum > maxLeftSum) {
                maxLeftSum = sum;
            }
        }

        int maxRightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i=mid + 1; i<=end; i++) {
            sum = sum + nums[i];

            if (sum > maxRightSum) {
                maxRightSum = sum;
            }
        }

        return maxLeftSum + maxRightSum;
    }

    public void test() {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int output = this.maxSubArrayDivideEtConquer(array);
        Log.w("TEST", "[-2,1,-3,4,-1,2,1,-5,4], 6 ==? " + output);
    }
}
