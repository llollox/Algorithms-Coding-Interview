package com.llollox.algorithms.problems.crack.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestKTest {

    private SmallestK smallestK = new SmallestK();

    @Test
    public void smallestKReImplemented() {
        int[] input = {4, 5, 7, 1, 9, 10, 12, 3, 2, 6};
        int[] output = smallestK.smallestKReImplemented(input, 3);
        int[] expected = {1, 2, 3};
        Assert.assertArrayEquals(expected, output);
    }
}