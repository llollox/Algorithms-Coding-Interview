package previmedical.it.leetcode.problems.easy;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class N697_DegreeOfAnArray {

    /*
        Given a non-empty array of non-negative integers nums,
        the degree of this array is defined as the maximum frequency of any one of its elements.

        Your task is to find the smallest possible length of a
        (contiguous) subarray of nums, that has the same degree as nums.

        Example 1:
        Input: [1, 2, 2, 3, 1]
        Output: 2

        Explanation:
        The input array has a degree of 2 because both elements 1 and 2 appear twice.
        Of the subarrays that have the same degree:
        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
        The shortest length is 2. So return 2.


        Example 2:
        Input: [1,2,2,3,1,4,2]
        Output: 6
     */

    // Una volta determinata la distanza di ogni elemento dalla prima all'ultima occorrenza,
    // posso sapere qual'eè quello col massimo grado e distanza minima.
    // Looppo tra gli elementi dell'array
    //  se non ho l'elemento nella mappa allora lo inserisco come first e last e la posizione corrente.
    //  se invece ce l'ho già allora aggiorno solo il last occurrences
    //  Mentre looppo salvo anche il numero di occorrenze trovate salvandomi anche qual'e il massimo corrente.
    // Alla fine del ciclo prendo il massimo e ritorno la lunghezza dalla sua prima all'ultima occorrenza.

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> firstOccurrencesMap = new HashMap<>();
        HashMap<Integer, Integer> lastOccurrencesMap = new HashMap<>();
        HashMap<Integer, Integer> numOccurrencesMap = new HashMap<>();

        HashSet<Integer> mostRecurrentValues = new HashSet<>();

        int maxOccurrences = 0;

        for (int i=0; i<nums.length; i++) {

            int val = nums[i];

            // Ce l'ho gia', aggiorno il last
            if (numOccurrencesMap.containsKey(val)) {

                lastOccurrencesMap.put(val, i);
                numOccurrencesMap.put(val, numOccurrencesMap.get(val) + 1);
            }
            else {

                // Non ce l'ho, lo aggiungo sia a first che last
                firstOccurrencesMap.put(val, i);
                lastOccurrencesMap.put(val, i);
                numOccurrencesMap.put(val, 1);
            }

            if (maxOccurrences < numOccurrencesMap.get(val)) {
                maxOccurrences = numOccurrencesMap.get(val);
                mostRecurrentValues.clear();
                mostRecurrentValues.add(val);
            }
            else if (maxOccurrences == numOccurrencesMap.get(val)) {
                mostRecurrentValues.add(val);
            }
        }

        int minLength = Integer.MAX_VALUE;

        for (Integer value : mostRecurrentValues) {
            int diff = lastOccurrencesMap.get(value) - firstOccurrencesMap.get(value) + 1;
            if (diff < minLength) {
                minLength = diff;
            }
        }

        return minLength;
    }

    public void test() {
//        int[] array1 = {1,2,2,3,1};
//        Log.w("Test", "{1,2,2,3,1} 2 ==? " + this.findShortestSubArray(array1));
//
//        int[] array2 = {1,2,2,3,1,4,2};
//        Log.w("Test", "{1,2,2,3,1,4,2} 6 ==? " + this.findShortestSubArray(array2));
//
//        int[] array3 = {1,1};
//        Log.w("Test", "{1,1} 2 ==? " + this.findShortestSubArray(array3));

        int[] array4 = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        Log.w("Test", "{2,1,1,2,1,3,3,3,1,3,1,3,2} 7 ==? " + this.findShortestSubArray(array4));
    }
}
