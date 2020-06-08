package com.llollox.algorithms.problems.crack.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindDuplicatesTest {

    private FindDuplicates findDuplicates = new FindDuplicates();

    @Test
    public void printDuplicates() {
        int[] input = {1, 4, 2, 1, 3, 1, 38, 2, 8, 1, 2, 9};
        List<Integer> expected = Arrays.asList(1, 1, 2, 1, 2);
        assertEquals(expected, findDuplicates.printDuplicates(input));
    }
}
