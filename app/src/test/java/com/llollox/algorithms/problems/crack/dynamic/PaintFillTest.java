package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaintFillTest {

    private PaintFill paintFill = new PaintFill();

    @Test
    public void paintFill() {
        int[][] matrix = {
                { 1 ,2, 3 },
                { 1, 2, 3 },
                { 1, 2, 3 }
        };

        paintFill.paintFill(matrix, 1, 1, 4);

        Assert.assertEquals(4, matrix[0][1]);
        Assert.assertEquals(4, matrix[1][1]);
        Assert.assertEquals(4, matrix[2][1]);
    }
}