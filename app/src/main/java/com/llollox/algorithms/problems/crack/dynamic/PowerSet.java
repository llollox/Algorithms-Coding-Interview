package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    /* Write a method to return all subsets of a set. */


    public List<List<Integer>> powerSetRecursive(List<Integer> list) {
        if (list == null) {
            return null;
        }
        return powerSetRecursive(list, list.size() - 1);
    }

    public ArrayList<List<Integer>> powerSetRecursive(List<Integer> list, int i) {

        if (i == -1) {
            ArrayList<List<Integer>> r = new ArrayList<>();
            r.add(new ArrayList<Integer>());
            return r;
        }

        ArrayList<List<Integer>> prev = this.powerSetRecursive(list, i - 1);
        int n = prev.size();

        for (int j=0; j<n; j++) {

            List<Integer> e = prev.get(j);
            ArrayList<Integer> rr = new ArrayList<>(e);
            rr.add(list.get(i));
            prev.add(rr);
        }

        return prev;

    }

    public List<List<Integer>> powerSetIterative(List<Integer> list) {

        if (list == null) {
            return null;
        }

        ArrayList<List<Integer>> r = new ArrayList<>();
        r.add(new ArrayList<Integer>());

        for (int v : list) {
            int n = r.size();
            for (int j=0; j<n; j++) {
                List<Integer> e = r.get(j);
                ArrayList<Integer> rr = new ArrayList<>(e);
                rr.add(v);
                r.add(rr);
            }
        }

        return r;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<List<Integer>> powerSetReImplemented(List<Integer> set) {
        ArrayList<List<Integer>> solutions = new ArrayList<>();

        if (set == null || set.size() == 0) {
            solutions.add(new ArrayList<Integer>());
            return solutions;
        }

        powerSetReImplemented(set, 0, solutions, new ArrayList<Integer>());
        return solutions;
    }

    private void powerSetReImplemented(
            List<Integer> set, int i,
            ArrayList<List<Integer>> solutions,
            ArrayList<Integer> solution) {

        if (i == set.size()) {
            solutions.add(solution);
            return;
        }

        // Non prendo l'elemento
        powerSetReImplemented(set, i + 1, solutions, new ArrayList<>(solution));

        // Prendo l'elemento
        solution.add(set.get(i));
        powerSetReImplemented(set, i + 1, solutions, new ArrayList<>(solution));
    }
}
