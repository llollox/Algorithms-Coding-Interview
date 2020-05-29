package com.llollox.algorithms.problems.crack.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryToStringTest {

    private BinaryToString binaryToString = new BinaryToString();

    @Test
    public void binaryToStringReImplemented() {
        Assert.assertEquals("ERROR", binaryToString.binaryToStringReImplemented(0.3));
    }

    @Test
    public void binaryToStringReImplemented2() {
        Assert.assertEquals(".1", binaryToString.binaryToStringReImplemented(0.5));
    }

    @Test
    public void binaryToStringReImplemented3() {
        Assert.assertEquals(".11", binaryToString.binaryToStringReImplemented(0.75));
    }

    @Test
    public void binaryToString() {
        Assert.assertEquals("ERROR", binaryToString.binaryToString(0.3));
    }

    @Test
    public void binaryToString2() {
        Assert.assertEquals(".1", binaryToString.binaryToString(0.5));
    }

    @Test
    public void binaryToString3() {
        Assert.assertEquals(".11", binaryToString.binaryToString(0.75));
    }
}
