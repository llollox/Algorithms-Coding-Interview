package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
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

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            int sbSize = permutationsSb.size();

            for (int j = 0; j< sbSize; j++) {
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
}
