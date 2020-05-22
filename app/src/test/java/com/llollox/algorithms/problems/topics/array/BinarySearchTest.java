package com.llollox.algorithms.problems.topics.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void binarySearch() {

        int[] array = {1,2,3,4};
        Assert.assertTrue(binarySearch.binarySearch(array, 1));
        Assert.assertTrue(binarySearch.binarySearch(array, 2));
        Assert.assertTrue(binarySearch.binarySearch(array, 3));
        Assert.assertTrue(binarySearch.binarySearch(array, 4));
        Assert.assertFalse(binarySearch.binarySearch(array, 5));
    }
}