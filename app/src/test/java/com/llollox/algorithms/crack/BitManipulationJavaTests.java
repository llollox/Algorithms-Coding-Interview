package com.llollox.algorithms.crack;

import org.junit.Assert;
import org.junit.Test;

public class BitManipulationJavaTests {

    @Test
    public void arithmeticPush__pushToLeft() {
        // -3 == 1..1101
        // 1..11010 (-6) Push 0 from right <<< (-3 * 2)
        // Arithmetic shift pushes only 0 from right

        Assert.assertEquals(-6, -3 << 1); // Arithmetic Push
    }

    @Test
    public void arithmeticPush__pushToRight() {
        // 3 == 11
        // -3 == 1..1101
        // >> 1 Push 1 to right. 1..1110 (-2)

        Assert.assertEquals(-2, -3 >> 1); // Arithmetic Push
    }

    @Test
    public void logicPush3__pushToRight() {
        // 3 == 11
        // -3 == 1..1101
        // >>> 1 push 1 as first => 011...1101
        int n = -3;
        Assert.assertEquals(2147483646, n >>> 1);
    }
}
