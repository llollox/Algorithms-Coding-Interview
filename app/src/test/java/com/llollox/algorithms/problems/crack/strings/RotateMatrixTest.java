package com.llollox.algorithms.problems.crack.strings;

import org.junit.Assert;
import org.junit.Test;

public class RotateMatrixTest {

    private RotateMatrix rotateMatrix = new RotateMatrix();

    @Test
    public void testRotateMatrix2x2() {
        int[][] input = {{1, 1}, {2, 2}};
        /*
            1 1
            2 2
         */
        int[][] expected = {{2, 1}, {2, 1}};
        Assert.assertArrayEquals(expected, rotateMatrix.rotateMatrix(input));
    }

    @Test
    public void testRotateMatrix3x3() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, { 7, 8, 9}};
        /*
            1 2 3
            4 5 6
            7 8 9
         */
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertArrayEquals(expected, rotateMatrix.rotateMatrix(input));
    }

    @Test
    public void testRotateMatrix5x5() {
        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int[][] expected = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 3, 3, 3, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        Assert.assertArrayEquals(expected, rotateMatrix.rotateMatrix(input));
    }
}
