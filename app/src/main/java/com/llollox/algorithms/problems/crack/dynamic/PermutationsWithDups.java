package com.llollox.algorithms.problems.crack.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PermutationsWithDups {
    /*
        Write a method to compute all permutations of a string whose characters are not necessarily unique.
        The list of permutations should not have duplicates.
     */

    public Set<String> recursive(String s) {
        if (s == null || s.length() == 0) {
            return new HashSet<>();
        }

        HashMap<Character, Integer> frequency = buildFrequencyMap(s);
        HashSet<String> solutions = new HashSet<>();
        helper(frequency, solutions, new StringBuilder(), s);
        return solutions;
    }

    private void helper(HashMap<Character, Integer> freqMap, Set<String> solutions, StringBuilder sb, String s) {
        if (sb.length() == s.length()) {
            solutions.add(sb.toString());
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (canBeChosen(freqMap, c)) {
                sb.append(c);
                decrement(freqMap, c);
                helper(freqMap, solutions, sb, s);
                increment(freqMap, c);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private HashMap<Character, Integer> buildFrequencyMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            increment(map, c);
        }
        return map;
    }

    private void decrement(HashMap<Character, Integer> map, Character key) {
        map.put(key, map.getOrDefault(key, 0) - 1);
    }

    private void increment(HashMap<Character, Integer> map, Character key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private boolean canBeChosen(HashMap<Character, Integer> map, Character key) {
        return map.getOrDefault(key, 0) > 0;
    }
}
