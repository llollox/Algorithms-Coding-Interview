package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSearchNoSizeTest {

    private SortedSearchNoSize sortedSearchNoSize = new SortedSearchNoSize();

    @Test
    public void sortedSearchNoSize() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortedSearchNoSize.Linky linky = new SortedSearchNoSize.Linky(array);
        Assert.assertEquals(3, sortedSearchNoSize.sortedSearchNoSize(linky, 4));
        Assert.assertEquals(9, sortedSearchNoSize.sortedSearchNoSize(linky, 10));
    }
}