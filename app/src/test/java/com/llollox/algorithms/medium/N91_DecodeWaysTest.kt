package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N91_DecodeWays
import junit.framework.Assert.assertEquals
import org.junit.Test

class N91_DecodeWaysTest {

    private val decodeWays = N91_DecodeWays()

    @Test
    fun test1() {
        assertEquals(2, decodeWays.numWays("12"))
    }

    @Test
    fun test2() {
        assertEquals(3, decodeWays.numWays("226"))
    }
}