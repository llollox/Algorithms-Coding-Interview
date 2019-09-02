package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N15_3Sum
import junit.framework.Assert.assertEquals
import org.junit.Test

class N15_3Sum_Test {

    @Test
    fun n15_3sum_test() {
        val n15_3sum = N15_3Sum()
        val array = intArrayOf(-1, 0, 1, 2, -1, -4)
        val output = n15_3sum.findIndexesToSum(array)
        assertEquals(2, output.size)
    }

    @Test
    fun n15_3sum_test2() {
        val n15_3sum = N15_3Sum()
        val input2 = intArrayOf(-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0)
        val output2 = n15_3sum.findIndexesToSum(input2)
        assertEquals(6, output2.size)
    }

    @Test
    fun n15_3sum_sorting_test() {
        val n15_3sum = N15_3Sum()
        val array = intArrayOf(-1, 0, 1, 2, -1, -4)
        val output = n15_3sum.threeSum(array)
        assertEquals(2, output.size)
    }

    @Test
    fun n15_3sum_sorting_test2() {
        val n15_3sum = N15_3Sum()
        val input2 = intArrayOf(-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0)
        val output2 = n15_3sum.threeSum(input2)
        assertEquals(6, output2.size)
    }
}