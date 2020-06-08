package com.llollox.algorithms.problems.topics.searching;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void binarySearch() {
        int[] input = {1, 2, 3, 8, 9, 12, 91};
        Assert.assertEquals(3, binarySearch.binarySearch(input, 8));
    }

    @Test
    public void binarySearchFail() {
        int[] input = {1, 2, 3, 8, 9, 12, 91};
        Assert.assertEquals(-1, binarySearch.binarySearch(input, 829));
    }

    @Test
    public void binarySearchZero() {
        int[] input = {0, 1, 2, 3, 8, 9, 12, 91};
        Assert.assertEquals(0, binarySearch.binarySearch(input, 0));
    }

    @Test
    public void binarySearchMinus10() {
        int[] input = {0, 1, 2, 3, 8, 9, 12, 91};
        Assert.assertEquals(-1, binarySearch.binarySearch(input, -10));
    }
}