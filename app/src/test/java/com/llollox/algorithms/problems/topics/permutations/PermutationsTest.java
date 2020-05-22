package com.llollox.algorithms.problems.topics.permutations;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    private Permutations permutations = new Permutations();

    @Test
    public void permutations() {
        int[] input = {1};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        Assert.assertEquals(expected, permutations.permutations(input).get(0));
    }

    @Test
    public void permutations2() {
        int[] input = {1, 2};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(2, 1));
        Assert.assertEquals(expected, permutations.permutations(input));
    }

    @Test
    public void permutations3() {
        int[] input = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList(1, 3, 2));
        expected.add(Arrays.asList(2, 1, 3));
        expected.add(Arrays.asList(2, 3, 1));
        expected.add(Arrays.asList(3, 1, 2));
        expected.add(Arrays.asList(3, 2, 1));
        Assert.assertEquals(expected, permutations.permutations(input));
    }
}
