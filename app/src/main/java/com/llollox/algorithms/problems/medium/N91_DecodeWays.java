package com.llollox.algorithms.problems.medium;

import java.util.HashMap;

public class N91_DecodeWays {

    /*
        A message containing letters from A-Z is being encoded to numbers using the following mapping:
        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given a non-empty string containing only digits, determine the total number of ways to decode it.

        Example 1:

        Input: "12"
        Output: 2
        Explanation: It could be decoded as "AB" (1 2) or "L" (12).
        Example 2:

        Input: "226"
        Output: 3
        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */

    /*
        Approach:
        - At each step I can:
            - take 1 digit
            - take 2 digits if the number is <= 26
            - apply memo<Integer, Integer>
     */

    public int numWays(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return numWays(s, 0, new HashMap<Integer, Integer>());
    }

    private int numWays(String s, int index, HashMap<Integer, Integer> memo) {
        if (index >= s.length()) {
            return 1;
        }

        if (memo.get(index) != null) {
            return memo.get(index);
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        int numWays = numWays(s, index + 1, memo);

        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            numWays += numWays(s,index + 2,memo);
        }

        memo.put(index, numWays);
        return numWays;
    }
}
