package com.llollox.algorithms.problems.crack.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlipBitToWinTest {

    private FlipBitToWin flipBitToWin = new FlipBitToWin();

    @Test
    public void flipToWinReImplemented() {
        Assert.assertEquals(8, flipBitToWin.flipToWinReImplemented(1775));
    }
}
