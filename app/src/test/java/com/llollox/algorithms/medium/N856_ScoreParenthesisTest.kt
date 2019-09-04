package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N856_ScoreParenthesis
import junit.framework.Assert.assertEquals
import org.junit.Test

class N856_ScoreParenthesisTest {

    val n856ScoreParenthesis = N856_ScoreParenthesis()

    @Test
    fun test1() {
        assertEquals(1, n856ScoreParenthesis.scoreOfParentheses("()"))
    }

    @Test
    fun test2() {
        assertEquals(2, n856ScoreParenthesis.scoreOfParentheses("(())"))
    }

    @Test
    fun test3() {
        assertEquals(6, n856ScoreParenthesis.scoreOfParentheses("(()(()))"))
    }
}