package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsWithoutDups {

    /*
        Write a method to compute all permutations of a string of unique characters.
     */


    public List<String> permutations(String s) {

        if (s == null) {
            return null;
        }

        ArrayList<StringBuilder> permutationsSb = new ArrayList<>();
        permutationsSb.add(new StringBuilder());

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int sbSize = permutationsSb.size();

            for (int j = 0; j < sbSize; j++) {
                StringBuilder sb = permutationsSb.get(j);
                permutationsSb.add(new StringBuilder(sb.toString() + c));
            }

        }

        ArrayList<String> permutations = new ArrayList<>();
        for (StringBuilder sb : permutationsSb) {
            permutations.add(sb.toString());
        }

        return permutations;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<String> permutationsIterative(String s) {
        ArrayList<String> permutations = new ArrayList<>();
        if (s == null || s.length() == 0) return permutations;

        permutations.add("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ArrayList<String> newPermutations = new ArrayList<>();
            for (String p : permutations) {
                newPermutations.addAll(combine(p, c));
            }
            permutations = newPermutations;
        }

        return permutations;
    }

    // All combinations to insert the caratter ‘c’ into the prefix string
    private ArrayList<String> combine(String prefix, Character c) {
        ArrayList<String> solutions = new ArrayList<>();

        if (prefix == null || prefix.length() == 0) {
            solutions.add("" + c);
            return solutions;
        }

        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < sb.length(); i++) {
            sb.insert(i, c);
            solutions.add(sb.toString());
            sb.deleteCharAt(i);
        }

        sb.append(c);
        solutions.add(sb.toString());

        return solutions;
    }

    public ArrayList<String> permutationsRecursive(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> solutions = new ArrayList<>();
        permutationsHelper(new HashSet<Character>(), s, new StringBuilder(), solutions);
        return solutions;
    }

    private void permutationsHelper(
            HashSet<Character> chosen,
            String s,
            StringBuilder sb,
            ArrayList<String> solutions) {

        if (sb.length() == s.length()) {
            solutions.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chosen.contains(c)) {
                sb.append(c);
                chosen.add(c);
                permutationsHelper(chosen, s, sb, solutions);
                sb.deleteCharAt(sb.length() - 1);
                chosen.remove(c);
            }
        }
    }


}
