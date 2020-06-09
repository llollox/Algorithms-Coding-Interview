package com.llollox.algorithms.problems.crack.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestSuperSequenceTest {

    private ShortestSuperSequence shortestSuperSequence = new ShortestSuperSequence();

    @Test
    public void shortestSuperSequence() {
        int[] longer = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] shorter = {1, 5, 9};
        int[] expected = {7, 10};
        Assert.assertArrayEquals(expected, shortestSuperSequence.shortestSuperSequence(longer, shorter));
    }

    @Test
    public void shortestSuperSequenceOptimal() {
        int[] longer = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] shorter = {1, 5, 9};
        int[] expected = {7, 10};
        Assert.assertArrayEquals(expected, shortestSuperSequence.shortestSuperSequenceOptmial(longer, shorter));
    }
}