package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedMatrixSearchTest {

    private SortedMatrixSearch sortedMatrixSearch = new SortedMatrixSearch();

    private int[][] matrix = {
            {15, 20, 70, 85},
            {20, 35, 80, 95},
            {30, 55, 95, 105},
            {40, 80, 120, 120}
    };

    @Test
    public void findElement() {
        SortedMatrixSearch.Coordinate coordinate = sortedMatrixSearch.findElement(matrix, 85);
        Assert.assertEquals(0, coordinate.row);
        Assert.assertEquals(3, coordinate.col);
    }

    @Test
    public void findElementImproved() {
        SortedMatrixSearch.Coordinate coordinate = sortedMatrixSearch.findElementImproved(matrix, 85);
        Assert.assertEquals(0, coordinate.row);
        Assert.assertEquals(3, coordinate.col);
    }
}