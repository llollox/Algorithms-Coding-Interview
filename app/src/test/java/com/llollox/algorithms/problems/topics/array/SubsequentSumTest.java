package com.llollox.algorithms.problems.topics.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubsequentSumTest {

    private SubsequentSum subsequentSum = new SubsequentSum();

    @Test
    public void numSubsequentSum() {
        int[] array = {1, 2, 3, 4, -1, 1, 10};
        Assert.assertEquals(4, subsequentSum.numSubsequentSum(array, 10));
    }
}
