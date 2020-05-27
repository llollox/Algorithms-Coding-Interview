package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationsWithDupsTest {

    private PermutationsWithDups permutationsWithDups = new PermutationsWithDups();

    @Test
    public void recursive() {
        Assert.assertEquals(6, permutationsWithDups.recursive("abc").size());
    }

    @Test
    public void recursive2() {
        Assert.assertEquals(1, permutationsWithDups.recursive("aa").size());
    }

    @Test
    public void recursive3() {
        Assert.assertEquals(2, permutationsWithDups.recursive("ab").size());
    }

    @Test
    public void recursive4() {
        Assert.assertEquals(3, permutationsWithDups.recursive("aba").size());
    }

    @Test
    public void recursive5() {
        Assert.assertEquals(6, permutationsWithDups.recursive("abab").size());
    }
}