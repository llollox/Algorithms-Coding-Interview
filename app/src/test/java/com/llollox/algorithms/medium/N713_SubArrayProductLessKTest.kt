package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N713_SubArrayProductLessK
import junit.framework.Assert.assertEquals
import org.junit.Test

class N713_SubArrayProductLessKTest {


    @Test
    fun test() {
        val input = intArrayOf(10,9,10,4,3,8,3,3,6,2,10,10,9,3)
        val output = N713_SubArrayProductLessK().numProducts(input, 19)
        assertEquals(18, output)
    }
}