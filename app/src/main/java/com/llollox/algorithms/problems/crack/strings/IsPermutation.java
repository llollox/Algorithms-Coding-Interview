package com.llollox.algorithms.problems.crack.strings;

import java.util.Arrays;
import java.util.HashMap;

public class IsPermutation {

    /*
        Given two strings, write a method to decide if one is a permutation of the other.
     */

    // Time O(n log n) Space O(1)
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);

        char[] s2Array = s2.toCharArray();
        Arrays.sort(s2Array);

        return new String(s1Array).equals(new String(s2Array));
    }

    // Time O(n) Space O(n)
    public boolean isPermutationHashMap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer occurrences = map.get(c);
            if (occurrences == null) {
                occurrences = 0;
            }
            map.put(c, occurrences + 1);
        }

        for (char c : s2.toCharArray()) {
            Integer occurrences = map.get(c);
            if (occurrences == null) {
                return false;
            }
            else if (occurrences == 1) {
                map.remove(c);
            }
            else {
                map.put(c, occurrences - 1);
            }
        }

        return map.isEmpty();
    }

}
