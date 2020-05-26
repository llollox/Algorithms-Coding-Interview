package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

public class MagicIndexTest {

    private MagicIndex magicIndex = new MagicIndex();

    @Test
    public void findMagicIndexRecursive() {
        int[] input1 = {-1, 0, 5, 6, 7, 8};
        int[] input2 = {-2, 0, 2};
        int[] input3 = {-12, -8, -2, 0, 1, 3, 5, 7, 11, 19};

        Assert.assertEquals(-1, magicIndex.findMagicIndexRecursive(input1));
        Assert.assertEquals(2, magicIndex.findMagicIndexRecursive(input2));
        Assert.assertEquals(7, magicIndex.findMagicIndexRecursive(input3));
    }

    @Test
    public void findMagicIndexIteravite() {
        int[] input1 = {-1, 0, 5, 6, 7, 8};
        int[] input2 = {-2, 0, 2};
        int[] input3 = {-12, -8, -2, 0, 1, 3, 5, 7, 11, 19};

        Assert.assertEquals(-1, magicIndex.findMagicIndexIterative(input1));
        Assert.assertEquals(2, magicIndex.findMagicIndexIterative(input2));
        Assert.assertEquals(7, magicIndex.findMagicIndexIterative(input3));
    }

    @Test
    public void findMagicIndexWithDuplicates() {
        int[] input1 = {-1, 0, 0, 4, 7, 8};
        int[] input2 = {-2, 0, 2};
        int[] input3 = {-12, -8, -8, -8, -7, 3, 5, 7, 11, 19};

        Assert.assertEquals(-1, magicIndex.findMagicIndexWithDuplicates(input1));
        Assert.assertEquals(2, magicIndex.findMagicIndexWithDuplicates(input2));
        Assert.assertEquals(7, magicIndex.findMagicIndexWithDuplicates(input3));
    }
}