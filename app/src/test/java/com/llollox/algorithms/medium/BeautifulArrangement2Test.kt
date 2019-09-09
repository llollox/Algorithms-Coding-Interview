package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N667_BeautifulArrangement2
import junit.framework.Assert.assertEquals
import org.junit.Test

class BeautifulArrangement2Test {

    val beautifulArrangement2 = N667_BeautifulArrangement2()

    @Test
    fun test1() {
        val output = beautifulArrangement2.beautifulArrangement(3, 1)
        assertEquals(1, output[0])
        assertEquals(2, output[1])
        assertEquals(3, output[2])
    }

    @Test
    fun test2() {
        val output = beautifulArrangement2.beautifulArrangement(3, 2)
        assertEquals(1, output[0])
        assertEquals(3, output[1])
        assertEquals(2, output[2])
    }

    @Test
    fun test3() {
        val output = beautifulArrangement2.beautifulArrangement(10, 4)
        assertEquals(1, output[0])
        assertEquals(2, output[1])
        assertEquals(3, output[2])
        assertEquals(4, output[3])
        assertEquals(5, output[4])
        assertEquals(6, output[5])
        assertEquals(10, output[6])
        assertEquals(7, output[7])
        assertEquals(9, output[8])
        assertEquals(8, output[9])
    }

}