package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N767_ReorganizeString
import junit.framework.Assert.assertEquals
import org.junit.Test

class N767_ReorganizeStringTest {

    val n767Reorganizestring = N767_ReorganizeString()

    @Test
    fun test1() {
        assertEquals("aba", n767Reorganizestring.reorganizeString("aab"))
    }

    @Test
    fun test2() {
        assertEquals("", n767Reorganizestring.reorganizeString("aaab"))
    }

    @Test
    fun test3() {
        assertEquals("aba", n767Reorganizestring.reorganizeStringPriorityQueue("aab"))
    }

    @Test
    fun test4() {
        assertEquals("", n767Reorganizestring.reorganizeStringPriorityQueue("aaab"))
    }

    @Test
    fun test5() {
        assertEquals("bybxbybhbxbcbybjbnbybcbxbhbmbtbkbjbwbsbibnbrb", n767Reorganizestring.reorganizeStringPriorityQueue("bbbbbxbwhbbbbmsybtbbbbbkncyybnjbhxbbrxibcjybb"))
    }
}