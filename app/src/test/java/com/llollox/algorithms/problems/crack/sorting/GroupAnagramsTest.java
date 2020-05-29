package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GroupAnagramsTest {

    private GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    public void sortAnagrams() {
        ArrayList<String> input = new ArrayList<>();
        input.add("aba");
        input.add("baba");
        input.add("aab");
        input.add("abaa");
        input.add("abab");

        ArrayList<String> output = groupAnagrams.sortAnagrams(input);
        Assert.assertEquals(5, output.size());
    }
}