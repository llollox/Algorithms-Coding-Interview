package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermutationsWithDups {
    /*
        Write a method to compute all permutations of a string whose characters are not necessarily unique.
        The list of permutations should not have duplicates.
     */

    public ArrayList<String> recursive(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, Integer> frequency = buildFrequencyMap(s);
        ArrayList<String> solutions = new ArrayList<>();
        helper(frequency, solutions, new StringBuilder(), s.length());
        return solutions;
    }

    private void helper(
            HashMap<Character, Integer> freqMap,
            ArrayList<String> solutions,
            StringBuilder sb,
            int remaining) {

        if (remaining == 0) {
            solutions.add(sb.toString());
            return;
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            Character c = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                sb.append(c);
                decrement(freqMap, c);
                helper(freqMap, solutions, sb, remaining - 1);
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
        map.put(key, map.getOrDefault(key, 1) - 1);
    }

    private void increment(HashMap<Character, Integer> map, Character key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
