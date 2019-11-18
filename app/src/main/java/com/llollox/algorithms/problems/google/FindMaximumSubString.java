package com.llollox.algorithms.problems.google;

import java.util.HashMap;

public class FindMaximumSubString {

    /*
        Given a string s and an integer n, find the length of the longest substring such that
        the number of different characters is at most n.

        Sliding window approach: Time O(n) Space O(n)

        - Use two pointers, start and end = 0
        - Use a HashMap<Char, Integer> to count the number of occurrences of each character.
        - Int maxLength = Integer.MIN_VALUE
        - While end < s.length()
            - Put character to map
            - if map.size() < n
                - end += 1
                - maxLength = end - start if greater
            - else
                - Increase start and remove characters from map until map.size() < n
                - end += 1
        - returnMaxLength
     */



    public int getMaxSubstringLength(String s, int n) {
        if (s == null || s.isEmpty() || n == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            add(map, c);

            while(map.size() > n) {
                char cStart = s.charAt(start);
                remove(map, cStart);
                start += 1;
            }

            int length = (end - start) + 1;
            if (length > maxLength) {
                maxLength = length;
            }

            end += 1;
        }

        return maxLength;
    }

    private void add(HashMap<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        }
        else {
            map.put(c, 1);
        }
    }

    private void remove(HashMap<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            int occurrences = map.get(c);
            if (occurrences == 1) {
                map.remove(c);
            }
            else {
                map.put(c, map.get(c) - 1);
            }
        }
    }

}
