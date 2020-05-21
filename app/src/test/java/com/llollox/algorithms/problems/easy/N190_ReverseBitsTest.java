package com.llollox.algorithms.problems.easy;

import org.junit.Assert;
import org.junit.Test;

public class N190_ReverseBitsTest {


    @Test
    public void assertShiftLeft() {
        int n = 2;
        n <<= 1;
        Assert.assertEquals(4, n);
    }

    @Test
    public void assertShiftRight() {
        int n = 4;
        n >>= 1;
        Assert.assertEquals(2, n);
    }

    @Test
    public void setLastDigit() {
        int n = 2;
        n |= 1;
        Assert.assertEquals(3, n);
    }
}
