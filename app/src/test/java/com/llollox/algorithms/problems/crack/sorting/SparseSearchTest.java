package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SparseSearchTest {

    private SparseSearch sparseSearch = new SparseSearch();

    @Test
    public void sparseSearch() {
        String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        Assert.assertEquals(4, sparseSearch.sparseSearch(input, "ball"));
    }
}
