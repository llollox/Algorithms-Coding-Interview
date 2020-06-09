package com.llollox.algorithms.problems.crack.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MasseuseTest {

    private Masseuse masseuse = new Masseuse();

    @Test
    public void masseuse() {
        int[] input = {30, 15, 60, 75, 45, 15, 15, 45};
        Assert.assertEquals(180, masseuse.masseuse(input));

    }
}