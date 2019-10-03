package com.llollox.algorithms.datastructures

import com.llollox.algorithms.datastructure.SegmentTree
import junit.framework.Assert
import org.junit.Test

class SegmentTreeTest {

    @Test
    fun test1() {
        val array = intArrayOf(1, 2, 3, 4, 5, 6)
        val st = SegmentTree(array)
        Assert.assertEquals(12, st.sum(2, 4))
    }
}