package com.llollox.algorithms.problems.crack.hard;

public class Masseuse {

    /*
        A popular masseuse receives a sequence of back-to-back appointment requests and
        is debating which ones to accept.
        She needs a 15-minute break between appointments and therefore she cannot accept any adjacent requests.
        Given a sequence of back-to-back appointment requests
        (all multiples of 15 minutes, none overlap, and none can be moved),
        find the optimal (highest total booked minutes) set the masseuse can honor.
        Return the number of minutes.

        EXAMPLE
        Input: {30, 15, 60, 75, 45, 15, 15, 45}
        Output: 180 minutes ({30, 60, 45, 45})
     */


    public int maxMinutes(int[] minutes) {
        if (minutes == null || minutes.length == 0) {
            return 0;
        }

        int[] DP = new int[minutes.length];

        return maxMinutes(minutes, 0, DP);
    }

    private int maxMinutes(int[] minutes, int i, int[] DP) {
        if (i >= minutes.length) {
            return 0;
        }

        if (DP[i] == 0) {
            DP[i] = Math.max(
                    minutes[i] + maxMinutes(minutes, i + 2, DP),
                    maxMinutes(minutes, i + 1, DP));
        }

        return DP[i];
    }


    // Iterative Approach
    /*
        DP[i] = Max min con i primi i elementi
                Max tra:
                    - Prendere elemento i + DP[i - 2]
                    - Non prendere elemento i, quindi DP[i - 1]
     */

    public int maxMinutesIterative(int[] minutes) {
        int[] DP = new int[minutes.length];

        for (int i=0; i<minutes.length; i++) {
            DP[i] = Math.max(
                    minutes[i] + getValue(DP, i - 2),
                    getValue(DP, i - 1));
        }

        return DP[minutes.length - 1];
    }

    private int getValue(int[] DP, int i) {
        return i >= 0 && i < DP.length ? DP[i] : 0;
    }



    public int maxMinutesIterativeOptimal(int[] minutes) {

        int dpMinusTwo = 0;
        int dpMinusOne = 0;
        int value = 0;

        for (int m : minutes) {

            value = Math.max(m + dpMinusTwo, dpMinusOne);

            dpMinusTwo = dpMinusOne;
            dpMinusOne = value;
        }

        return value;
    }
}
