package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetTest {

    private PowerSet powerSet = new PowerSet();

    @Test
    public void powerSetReImplemented() {
        List<Integer> set = Arrays.asList(1, 2, 3);
        ArrayList<List<Integer>> output = powerSet.powerSetReImplemented(set);

        Assert.assertEquals(8, output.size());
    }
}