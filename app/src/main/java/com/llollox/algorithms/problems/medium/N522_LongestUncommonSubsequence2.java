package com.llollox.algorithms.problems.medium;

public class N522_LongestUncommonSubsequence2 {

    /*
        Given a list of strings, you need to find the longest uncommon subsequence among them.
        The longest uncommon subsequence is defined as the longest subsequence of one of
        these strings and this subsequence should not be any subsequence of the other strings.

        A subsequence is a sequence that can be derived from one sequence by deleting
        some characters without changing the order of the remaining elements.
        Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

        The input will be a list of strings,
        and the output needs to be the length of the longest uncommon subsequence.
        If the longest uncommon subsequence doesn't exist, return -1.

        Example 1:
        Input: "aba", "cdc", "eae", "prova"
        Output: 3

        Note:
        All the given strings' lengths will not exceed 10.
        The length of the given list will be in the range of [2, 50].
     */

    /*
        Time O(K) Space O(1), K is the length of the longest string
        Given two strings, how to see if one is subsequence of the other?
            - Trovo la stringa più lunga delle due.
            - Utilizzo un indice in longer ed uno in shorter
            - Finchè shorter < shorter.length && longer < longer.length
                - Avanzo l'indice in longer fintanto che trovo il carattere in shorter
                - Quando lo trovo:
                    longer += 1
                    shorter += 1
            - return shorter == shorter.length && longer == longer.length
     */

    /*
        Approach 1
        - Ordino le parole per lunghezza in ordine inverso
        - Parto dalla più lunga e provo a vedere se è sottostringa delle altre
        - La prima che trovo che non è sottostringa la rimuovo
     */

//    public int findLUSlength(String[] strs) {
//
//    }


    // Sol2: Check with all strings.
    // Time: O(n^2 * x). n: the # of strs, x: the average length of strings.
    public String findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int max = -1;
        String maxString = "";

        for (int i = 0; i < strs.length; i++) {

            int j = 0;
            for (; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {  // left is smaller, right is larger
                    break;
                }
            }
            if (j == strs.length) {
                max = Math.max(max, strs[i].length());
                maxString = maxString.length() > strs[i].length() ? maxString : strs[i];
            }
        }
        return maxString;
    }
    // check if x is a subsequence of y
    // O(max(x.length(), y.length()))
    private boolean isSubsequence (String small, String large) {
        int j = 0;
        for (int i = 0; i < large.length() && j < small.length(); i++) {
            if (large.charAt(i) == small.charAt(j)) {
                j++;
            }
        }
        return j == small.length();
    }




}
