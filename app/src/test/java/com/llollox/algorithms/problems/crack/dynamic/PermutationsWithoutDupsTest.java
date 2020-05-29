package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PermutationsWithoutDupsTest {

    private PermutationsWithoutDups permutationsWithoutDups = new PermutationsWithoutDups();

    @Test
    public void permutationsIterative() {
        ArrayList<String> solutions = permutationsWithoutDups.permutationsIterative("abc");
        Assert.assertEquals(6, solutions.size());
    }

    @Test
    public void permutationsIterative2() {
        ArrayList<String> solutions = permutationsWithoutDups.permutationsIterative("abcd");
        Assert.assertEquals(24, solutions.size());
    }

    @Test
    public void permutationsRecursive() {
        ArrayList<String> solutions = permutationsWithoutDups.permutationsRecursive("abc");
        Assert.assertEquals(6, solutions.size());
    }

    @Test
    public void permutationsRecursive2() {
        ArrayList<String> solutions = permutationsWithoutDups.permutationsRecursive("abcd");
        Assert.assertEquals(24, solutions.size());
    }
}