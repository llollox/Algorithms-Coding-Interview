package com.llollox.algorithms.problems.crack.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiSearchReImplementedTest {

    private MultiSearchReImplemented multiSearch = new MultiSearchReImplemented();

    @Test
    public void multiSearch() {
        String[] words = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        HashMap<String, ArrayList<Integer>> results = multiSearch.multiSearch("missisippi", words);
        Assert.assertEquals(4, results.size());
        Assert.assertEquals(4, results.get("i").size());

        Integer[] iExpected = {1, 4, 6, 9};
        Assert.assertArrayEquals(iExpected, results.get("i").toArray());

        Integer[] isExpected = {1, 4};
        Assert.assertArrayEquals(isExpected, results.get("is").toArray());

        Integer[] sisExpected = {3};
        Assert.assertArrayEquals(sisExpected, results.get("sis").toArray());

        Integer[] ppiExpected = {7};
        Assert.assertArrayEquals(ppiExpected, results.get("ppi").toArray());
    }
}