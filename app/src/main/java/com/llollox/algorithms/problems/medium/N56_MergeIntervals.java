package com.llollox.algorithms.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class N56_MergeIntervals {

    /*
        Given a collection of intervals, merge all overlapping intervals.

        Example 1:
        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        Example 2:
        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

        NOTE: input types have been changed on April 15, 2019.
        Please reset to default code definition to get new method signature.
     */

    /*
        Questions:
            - Does the array of intervals fit in memory? Yes
            - What if the array is null or empty or with 1 interval? Return the same
            - Can it contains negative integers? Yes
            - Can it contains duplicate intervals? Yes
            - Can I assume that all array has length 2? Yes
     */

    /*
           1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18
        0: -------
        1:    -------------
        2:                      --------
        3:                                                --------------

        Approach 1    Time O(n log n) Space O(n)
        - Initialize an ArrayList<Pair<Integer, Integer>> results
        - Order the intervals by start value Time O(n log n) Space O(1)
        - Save start (sc) and end (ec) value of first interval
        - Loop over all intervals. For each one [si, ei]: Time O(n) Space O(n)
            - If si > ec // interval is outside the current one
                - Add the interval [sc, ec] to results.
                - sc = si
                - ec = ei
            - else if ec < ei
                ec = ei

        - Add the last interval [sc, ec] to results.
        - Convert results into an array int[][] Time O(n) Space O(n)
     */

    public static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        int[][] sorted =  sortByStartValue(intervals);
        ArrayList<Pair> results = new ArrayList<>();

        int sc = intervals[0][0];
        int ec = intervals[0][1];

        for (int i=1; i<intervals.length; i++) {
            int si = intervals[i][0];
            int ei = intervals[i][1];

            if (si > ec) {
                results.add(new Pair(sc, ec));
                sc = si;
                ec = ei;
            }
            else if (ec < ei) {
                ec = ei;
            }
        }

        results.add(new Pair(sc, ec));

        return convertToArray(results);
    }

    private int[][] sortByStartValue(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        return intervals;
    }

    private int[][] convertToArray(List<Pair> list) {
        int[][] array = new int[list.size()][];
        for (int i=0; i<list.size(); i++) {
            Pair p = list.get(i);
            array[i] = new int[] {p.first, p.second};
        }
        return array;
    }


}
