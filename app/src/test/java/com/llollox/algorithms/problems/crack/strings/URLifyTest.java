package com.llollox.algorithms.problems.crack.strings;

import org.junit.Assert;
import org.junit.Test;

public class URLifyTest {

    private URLify urLify = new URLify();

    @Test
    public void verifiesTheyAreEqual() {
        String input = "Mr John Smith    ";
        String expected = "Mr%20John%20Smith";
        Assert.assertEquals(expected, urLify.urlifyImproved(input, 13));
    }
}
