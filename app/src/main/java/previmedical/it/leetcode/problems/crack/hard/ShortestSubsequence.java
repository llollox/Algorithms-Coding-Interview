package previmedical.it.leetcode.problems.crack.hard;


import java.util.HashSet;
import java.util.Set;

public class ShortestSubsequence {

    /*
        You are given two arrays, one shorter (with all distinct elements) and one longer.
        Find the shortest subarray in the longer array that contains all the elements in the shorter array.
        The items can appear in any order.

        EXAMPLE
        Input: A1 {1, 5, 9}                                            len M
               A2 {7, 5, 9, 0, 2, 1, 3, 5. 7, 9. 1, 1, 5, 8, 8, 9, 7}  len N
                                     s
                                                 e

        Output:[7, 10] (the underlined portion above)
     */


    /*
        APPROACH 1: O(N * K), K = N - M  Space O(A1)
          - For every length starting with M to N   O(K)
            - Slide a window and search if it contains all elements in A1  O(N)

          - How to check if the new array contains all elements? O(1)
            - Create a set S with all integers in A1
            - Keep a counter of elements found, when it reaches the length of S I finished.
            - At each iteration:
                - if the removed element is present into the set decrease
                - if the added element is present into the set increase


         APPROACH 2: Double Pointers  Time O(N)  Space O(A1)
           - Create a set S with all integers in A1   Space O(A1)
           - Start with two pointers s at index 0 and e at index 0.
           - Initialize a counter to 0
           - Initialize a min distance = Integer.MAX_VALUE
           - Move forward e until it reaches A1.length -1 taking the number of integers valid.
           - If the first val can be removed without decrement the counter:
                if length > MIN FOUND, s += 1
           - Altrimenti e += 1
           - Tengo traccia del minimo contando il numero di elementi validi
           - Quando trovo un subset valido, sposto avanti s di tanti posti fintanto che il counter scende di 1

     */


    public int[] shortestSubsequence(int[] longer, int[] shorter) {
        if (longer == null
                || shorter == null
                || shorter.length == 0
                || longer.length < shorter.length) {
            return null;
        }

        HashSet<Integer> shorterSet = new HashSet<>();
        for (int v : shorter) {
            shorterSet.add(v);
        }

        HashSet<Integer> valuesFound = new HashSet<>();
        int startMinSubsequence = 0;
        int endMinSubsequence = longer.length;

        for (int i=0; i<shorter.length; i++) {
            int value = longer[i];

            if (isValid(shorterSet, value)) {
                valuesFound.add(longer[i]);
            }
        }

        int start = 0;
        int end = shorter.length;

        while (end < longer.length) {

            if (start < end && !isValid(shorterSet, longer[start]) && numItems(end, start) > shorter.length) {
                start += 1;
            }
            else {

                int value = longer[end];

                if (isValid(shorterSet, value)) {
                    valuesFound.add(value);

                    if (valuesFound.size() == shorterSet.size()) {

                        // If the dimension of this new subsequnce is less then the minimum
                        if (numItems(end, start) < numItems(endMinSubsequence, startMinSubsequence)) {

                            // Sottosequenza trovata
                            startMinSubsequence = start;
                            endMinSubsequence = end;
                        }

                        while (valuesFound.size() == shorterSet.size()) {
                            valuesFound.remove(longer[start]);
                            start += 1;
                        }
                    }
                }

                end += 1;
            }

        }

        if (numItems(endMinSubsequence, startMinSubsequence) == longer.length) { // Subsequence not found
            return null;
        }

        return new int[] { startMinSubsequence, endMinSubsequence};
    }

    private boolean isValid(Set<Integer> set, int value) {
        return set.contains(value);
    }

    private int numItems(int end, int start) {
        return end - start;
    }
}
