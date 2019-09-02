package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N611_ValidTriangleNumber
import junit.framework.Assert.assertEquals
import org.junit.Test

class N611_ValidTriangleNumberTest {

    @Test
    fun n611_basicTest() {
        val n611Validtrianglenumber = N611_ValidTriangleNumber()
        val input = intArrayOf(2, 2, 3, 4)
        val output = n611Validtrianglenumber.numCombinations(input)
        assertEquals(3, output)
    }

}