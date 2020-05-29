package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParensTest {

    private Parens parens = new Parens();

    @Test
    public void parensReImplemented() {
        ArrayList<String> output = parens.parensReImplemented(3);

        Assert.assertEquals(5, output.size());
    }
}