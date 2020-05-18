package com.llollox.algorithms.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

public class BitSetTest {

    @Test
    public void test1() {
        BitSet bs = new BitSet(3);
        bs.set(0, true);
        bs.set(1, false);
        bs.set(2, true);

        Assert.assertTrue(bs.get(0));
        Assert.assertFalse(bs.get(1));
        Assert.assertTrue(bs.get(2));
    }
}
