package com.llollox.algorithms.datastructure;

import org.junit.Assert;
import org.junit.Test;

public class MfSetTest {

    @Test
    public void myTest() {

        MfSet mfSet = new MfSet(5);

        mfSet.merge(0, 2);
        mfSet.merge(4, 2);
        mfSet.merge(3, 1);

        Assert.assertEquals(mfSet.find(4), mfSet.find(0));
        Assert.assertNotEquals(mfSet.find(1), mfSet.find(0));
    }

}