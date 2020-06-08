package com.llollox.algorithms.problems.topics.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @Test
    public void myTest() {
        int[] input = {1, 3, 23, 8, 2, 9, 0, 5, 67, 12, 91};
        int[] expected = {0, 1, 2, 3, 5, 8, 9, 12, 23, 67, 91};
        Assert.assertArrayEquals(expected, quickSort.quickSort(input));
    }
}