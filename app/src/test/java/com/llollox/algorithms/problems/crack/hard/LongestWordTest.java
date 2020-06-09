package com.llollox.algorithms.problems.crack.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestWordTest {

    private LongestWord longestWord = new LongestWord();

    @Test
    public void longestWord() {
        String[] input = {"test", "ing", "prova", "computer", "telephone", "testing"};
        assertEquals("testing", longestWord.longestWord(input));
    }

    @Test
    public void longestWordReImplemented() {
        String[] input = {"test", "ing", "prova", "computer", "telephone", "testing"};
        assertEquals("testing", longestWord.longestWordReImplemented(input));
    }
}