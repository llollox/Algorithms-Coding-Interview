package com.llollox.algorithms.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class N539_MinimumTimeDifference {

    /*
        Given a list of 24-hour clock time points in "Hour:Minutes" format,
        find the minimum minutes difference between any two time points in the list.

        Example 1:
        Input: ["23:59","00:00"]
        Output: 1

        Note:
        The number of time points in the given list is at least 2 and won't exceed 20000.
        The input time is legal and ranges from 00:00 to 23:59.
     */

    /*
        - Parse each time and convert it into minutes expression.
            - 00:00 means 0
            - 23:59 means 59 + 23 * 60 = 1439
        - Ordino la lista di numeri
        - Scorro la lista ordinata per trovare la differenza minima
     */

    /*
        35, 331: 296
     */

    public int findMinDifference(List<String> timePoints) {

        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (String s : timePoints) {
            int time = parseTime(s);
            if (time >= 0) {
                list.add(time);
            }
        }

        Collections.sort(list);

        int min = Integer.MAX_VALUE;

        for (int i=0; i<list.size() - 1; i++) {
            int val = list.get(i);
            int next = list.get(i + 1);
            int diff = getDifference(val, next);
            if (diff < min) {
                min = diff;
            }
        }

        int circularDiff = (list.get(0) + 1440) - list.get(list.size() - 1);
        if (circularDiff < min) {
            min = circularDiff;
        }

        return min;
    }

    private int getDifference(int time1, int time2) {
        int diffCurrentDay = time2 - time1;
        int diffNextDay = (time1 + 1440) - time2;

        return Math.min(diffCurrentDay, diffNextDay);
    }

    private int parseTime(String s) {
        if (s == null || s.length() != 5) {
            return -1;
        }

        int hour = Integer.parseInt(s.substring(0, 2));
        int minutes = Integer.parseInt(s.substring(3));
        return hour * 60 + minutes;
    }
}
