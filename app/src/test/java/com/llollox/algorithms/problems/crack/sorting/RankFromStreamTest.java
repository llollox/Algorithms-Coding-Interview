package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Assert;
import org.junit.Test;

public class RankFromStreamTest {

    @Test
    public void test() {

        int[] input = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        RankFromStream.Ranker ranker = new RankFromStream.Ranker();
        for (int value : input) {
            ranker.track(value);
        }

        Assert.assertEquals(0, ranker.getRankOfNumber(1));
        Assert.assertEquals(1, ranker.getRankOfNumber(3));
        Assert.assertEquals(3, ranker.getRankOfNumber(4));
    }
}