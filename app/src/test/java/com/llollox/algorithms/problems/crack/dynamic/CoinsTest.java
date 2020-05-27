package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {

    private Coins coins = new Coins();

    @Test
    public void coinsReImplemented() {
        Assert.assertEquals(2, coins.coinsReImplemented(6));
        Assert.assertEquals(4, coins.coinsReImplemented(10));
        Assert.assertEquals(4, coins.coinsReImplemented(11));
        Assert.assertEquals(242, coins.coinsReImplemented(100));
    }

    @Test
    public void coinsReImplementedMemo() {
        Assert.assertEquals(2, coins.coinsReImplementedMemo(6));
        Assert.assertEquals(4, coins.coinsReImplementedMemo(10));
        Assert.assertEquals(4, coins.coinsReImplementedMemo(11));
        Assert.assertEquals(134235101, coins.coinsReImplementedMemo(10000));
        Assert.assertEquals(142511, coins.coinsReImplementedMemo(1000));
        Assert.assertEquals(134235101, coins.coinsReImplementedMemo(10000));
        Assert.assertEquals(1070270201, coins.coinsReImplementedMemo(20000));
    }

    @Test
    public void coinsReImplementedDP() {
        Assert.assertEquals(2, coins.coinsDP(6));
        Assert.assertEquals(4, coins.coinsDP(10));
        Assert.assertEquals(4, coins.coinsDP(11));
        Assert.assertEquals(242, coins.coinsDP(100));
        Assert.assertEquals(142511, coins.coinsDP(1000));
        Assert.assertEquals(134235101, coins.coinsDP(10000));
        Assert.assertEquals(1070270201, coins.coinsDP(20000));
    }
}