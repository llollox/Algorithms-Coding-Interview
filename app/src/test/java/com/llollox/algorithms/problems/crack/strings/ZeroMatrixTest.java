package com.llollox.algorithms.problems.crack.strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroMatrixTest {

    private ZeroMatrix zeroMatrix = new ZeroMatrix();

    @Test
    public void nullify() {
        int[][] input = {{1, 0, 2}, {3, 4, 5}, {0, 1, 2}};
        int[][] expected = { {0, 0, 0}, {0, 0, 5}, {0, 0, 0} };
        int[][] output = zeroMatrix.nullify(input);
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void nullifyImproved() {
        int[][] input = {{1, 0, 2}, {3, 4, 5}, {0, 1, 2}};
        int[][] expected = { {0, 0, 0}, {0, 0, 5}, {0, 0, 0} };
        int[][] output = zeroMatrix.nullifyImproved(input);
        Assert.assertArrayEquals(expected, output);
    }
}
