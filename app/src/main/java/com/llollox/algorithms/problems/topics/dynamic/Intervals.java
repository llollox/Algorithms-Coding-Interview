package com.llollox.algorithms.problems.topics.dynamic;

import com.llollox.algorithms.problems.topics.models.Interval;

public class Intervals {
    /*
        Dato un insieme di intervalli pesati.
        Trovare il sottoinsieme di intervalli DISGIUNTI tale che il profitto sia massimo.


        [1,3] = 4
        [3,6] = 4
        [1,5] = 7

     */


    public int maxProfit(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals[intervals.length - 1].end;
        int[] dp = new int[n+1];

        for (int t=0; t<n+1; t++) {

            int max = 0;
            for (Interval interval: intervals) {
                if (interval.end == t) {
                    int val = dp[interval.start] + interval.profit;
                    if (val > max) {
                        max = val;
                    }
                }
            }

            dp[t] = max;
        }

        return dp[n];
    }
}
