package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EightQueensTest {

    private EightQueens eightQueens = new EightQueens();

    @Test
    public void queensReImplemented() {
        ArrayList<EightQueens.Point> solutions = eightQueens.queensReImplemented();
        Assert.assertEquals(8, solutions.size());
    }
}