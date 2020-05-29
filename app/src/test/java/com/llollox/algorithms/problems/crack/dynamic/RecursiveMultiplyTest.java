package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveMultiplyTest {

    private RecursiveMultiply recursiveMultiply = new RecursiveMultiply();

    @Test
    public void recursiveMultiplyReImplemented() {
        Assert.assertEquals(32, recursiveMultiply.recursiveMultiplyReImplemented(4, 8));
    }

    @Test
    public void recursiveMultiplyReImplementedOptmial() {
        Assert.assertEquals(169, recursiveMultiply.recursiveMultiplyReImplementedOptimal(13, 13));
    }
}