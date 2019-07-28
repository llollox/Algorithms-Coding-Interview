package previmedical.it.leetcode.problems.crack.moderate;

public class SubSort {

    /*
    Given an array of integers, write a method to find indices m and n such that
    if you sorted elements m through n, the entire array would be sorted.

    Minimize n - m (that is, find the smallest such sequence).

    EXAMPLE
    Input:1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
    Output: (3, 9)
     */

    public class Result {
        public int m;
        public int n;

        public Result(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

    public Result getSub(int[] array) {

        // Corner cases
        if (array == null || array.length < 2) {
            return null;
        }

        int m=0;
        int n=array.length -1;

        // Find increasing subsequence
        while (array[m] < array[m+1] && m < array.length - 1) {
            m += 1;
        }

        // Array already sorted
        if (m == array.length - 1) {
            return null;
        }

        // Find decreasing subsequence
        while (array[n - 1] < array[n] && n > m) {
            n -= 1;
        }

        // Compare end smaller and start greater
        while (array[m] > array[n] && m - 1 >= 0 && n + 1 < array.length) {
            m -= 1;
            n += 1;
        }

        // Find min & max within middle
        int minMiddle = Integer.MAX_VALUE;
        int maxMiddle = Integer.MIN_VALUE;

        for (int i=m; i<=n; i++) {
            if (array[i] < minMiddle) {
                minMiddle = array[i];
            }
            if (array[i] > maxMiddle) {
                maxMiddle = array[i];
            }
        }

        // Expand array in both sides
        while(array[m] > minMiddle && m - 1 >= 0) {
            m = m -1;
        }
        while(array[n] < maxMiddle && n + 1 < array.length) {
            n = n + 1;
        }

        return new Result(m + 1,n - 1);
    }

}
