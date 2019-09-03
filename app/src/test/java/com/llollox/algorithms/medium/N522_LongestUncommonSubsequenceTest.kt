package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N522_LongestUncommonSubsequence2
import junit.framework.Assert.assertEquals
import org.junit.Test

class N522_LongestUncommonSubsequenceTest {

    @Test
    fun test1() {
        val N522_LongestUncommonSubsequence2 = N522_LongestUncommonSubsequence2()
        val input = arrayOf("aba", "cdc", "eae")
        val output = N522_LongestUncommonSubsequence2.findLUSlength(input)
        assertEquals("eae", output)
    }

}