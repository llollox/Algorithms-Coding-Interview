package previmedical.it.leetcode.unitn

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.dynamic.Intervals

class DynamicTest {


    @Test
    fun interval() {
        val interval = Intervals()

        val intervals = arrayOf(
            Intervals.Interval(0,2,4),
            Intervals.Interval(0,2,3),
            Intervals.Interval(0,4,7),
            Intervals.Interval(2,5,4))

        val output = interval.maxProfit(intervals)
        Assert.assertEquals(8, output)
    }
}