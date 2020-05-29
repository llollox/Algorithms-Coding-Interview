package com.llollox.algorithms.problems.crack.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionTest {

    private Conversion conversion = new Conversion();

    @Test
    public void conversion() {
        Assert.assertEquals(2, conversion.conversion(29, 15));
    }

    @Test
    public void conversionImproved() {
        Assert.assertEquals(2, conversion.conversionImproved(29, 15));
    }

    @Test
    public void conversionOptimal() {
        Assert.assertEquals(2, conversion.conversionOptimal(29, 15));
    }
}
