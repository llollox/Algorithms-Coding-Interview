package com.llollox.algorithms.problems.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class N762_PrimeNumberBitsSetInBinaryRepresentationTest {

    private N762_PrimeNumberBitsSetInBinaryRepresentation n762 = new N762_PrimeNumberBitsSetInBinaryRepresentation();

    @Test
    public void countPrimeSetBits() {
        Assert.assertEquals(16, n762.countPrimeSetBits(244, 269));
    }
}
