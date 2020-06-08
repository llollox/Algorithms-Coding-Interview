package com.llollox.algorithms.problems.crack.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReSpaceTest {

    private ReSpace reSpace = new ReSpace();

    @Test
    public void reSpaceTrie() {
        String input = "jesslookedjustliketimherbrother";
        List<String> dictionary = Arrays.asList("looked", "just", "like", "her", "brother");

        ReSpace.MyResult output = reSpace.reSpaceTrie(input, dictionary);
        assertEquals(7, output.unknownChars);
    }
}
