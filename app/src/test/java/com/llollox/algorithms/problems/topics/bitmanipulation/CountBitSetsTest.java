package com.llollox.algorithms.problems.topics.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountBitSetsTest {

    private CountBitSets countBitSets = new CountBitSets();

    @Test
    public void test() {
        Assert.assertEquals(4, countBitSets.bitCount(150));
    }
}
