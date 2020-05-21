package com.llollox.algorithms.problems.crack.treegraph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildOrderTest {

    private BuildOrder buildOrder = new BuildOrder();

    /*
        Input:
            projects: a, b, c, d, e, f
            dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
        Output:
            f, e, a, b, d, c
     */

    @Test
    public void order() {
        String[] input = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };
        String[] expected = {"f", "e", "b", "a", "d", "c"};
        Assert.assertArrayEquals(expected, buildOrder.order(input, dependencies));
    }

    @Test
    public void detectLoop() {
        String[] input = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"a", "f"},
                {"f", "a"},
                {"d", "c"}
        };
        String[] expected = {};
        Assert.assertArrayEquals(expected, buildOrder.order(input, dependencies));
    }
}
