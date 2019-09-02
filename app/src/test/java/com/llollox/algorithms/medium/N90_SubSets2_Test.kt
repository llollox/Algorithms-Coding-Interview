package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N90_Subsets2
import junit.framework.Assert.assertEquals
import org.junit.Test

class N90_SubSets2_Test {

    @Test
    fun subSet2_test() {
        val N90_Subsets2 = N90_Subsets2()
        val input = intArrayOf(1,2,2)
        val output = N90_Subsets2.subSets(input)
        assertEquals(5, output.size)
    }

}