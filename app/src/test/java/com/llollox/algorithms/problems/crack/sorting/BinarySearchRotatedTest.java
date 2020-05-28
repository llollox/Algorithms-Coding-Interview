package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchRotatedTest {

    private BinarySearchRotated binarySearchRotated = new BinarySearchRotated();

    @Test
    public void binarySearchRotated() {
        int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        Assert.assertEquals(8, binarySearchRotated.binarySearchRotated(input, 5));
    }

    @Test
    public void binarySearchRotated2() {
        int[] input = {2, 2, 2, 3, 4, 2};

        Assert.assertEquals(3, binarySearchRotated.binarySearchRotated(input, 3));
        Assert.assertEquals(4, binarySearchRotated.binarySearchRotated(input, 4));
    }
}