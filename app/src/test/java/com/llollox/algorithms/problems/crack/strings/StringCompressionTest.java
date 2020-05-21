package com.llollox.algorithms.problems.crack.strings;

import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {

    private StringCompression stringCompression = new StringCompression();

    @Test
    public void test() {
        String input = "aabcccccaaa";
        String expected = "a2b1c5a3";
        Assert.assertEquals(expected, stringCompression.compress(input));
    }
}
