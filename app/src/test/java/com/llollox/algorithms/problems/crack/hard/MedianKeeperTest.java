package com.llollox.algorithms.problems.crack.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedianKeeperTest {

    private MedianKeeper medianKeeper = new MedianKeeper();

    @Test
    public void test1() {
        Assert.assertEquals(0, medianKeeper.getMedian());
        medianKeeper.addValue(5);
        Assert.assertEquals(5, medianKeeper.getMedian());
        medianKeeper.addValue(3);
        Assert.assertEquals(4, medianKeeper.getMedian());
        medianKeeper.addValue(10);
        Assert.assertEquals(5, medianKeeper.getMedian());
        medianKeeper.addValue(100);
        Assert.assertEquals(7, medianKeeper.getMedian());
    }

}