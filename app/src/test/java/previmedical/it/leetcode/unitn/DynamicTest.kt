package previmedical.it.leetcode.unitn

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.dynamic.Intervals
import previmedical.it.leetcode.problems.unitn.models.Interval

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