package com.llollox.algorithms.problems.crack.bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionTest {

    private Insertion insertion = new Insertion();

    @Test
    public void insertion() {
        Assert.assertEquals(1100, insertion.insertion(1024, 19, 2, 6));
    }

    @Test
    public void insertionReImplemented() {
        Assert.assertEquals(1100, insertion.insertionReImplemented(1024, 19, 2, 6));
    }

    @Test
    public void insertion2() {
        Assert.assertEquals(221, insertion.insertion(213, 7, 2, 4));
    }

    @Test
    public void insertionReImplemented2() {
        Assert.assertEquals(221, insertion.insertionReImplemented(213, 7, 2, 4));
    }
}
