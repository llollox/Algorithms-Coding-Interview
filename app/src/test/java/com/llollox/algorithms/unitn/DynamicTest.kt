package com.llollox.algorithms.unitn

import org.junit.Assert
import org.junit.Test
import com.llollox.algorithms.problems.topics.dynamic.Intervals
import com.llollox.algorithms.problems.topics.models.Interval

class DynamicTest {


    @Test
    fun interval() {
        val interval = Intervals()

        val intervals = arrayOf(
            Interval(0,2,4),
        Interval(0,2,3),
        Interval(0,4,7),
        Interval(2,5,4))

        val output = interval.maxProfit(intervals)
        Assert.assertEquals(8, output)
    }
}
