package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedMergeTest {

    private SortedMerge sortedMerge = new SortedMerge();

    @Test
    public void sortedMergeReImplemented() {
        int[] a = {1, 3 ,7, 0, 0, 0};
        int[] b = {4, 6};
        sortedMerge.sortedMergeReImplemented(a, b, 2);

        int[] expected = {1,3,4,6,7,0};
        Assert.assertArrayEquals(expected, a);
    }
}