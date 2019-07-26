package previmedical.it.leetcode.unitn

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.greedy.MaxNumIntervals
import previmedical.it.leetcode.problems.unitn.models.Interval

class GreedyTest {

    @Test
    fun maxIntervals() {
        val maxIntervals = MaxNumIntervals()
        val intervals = arrayOf(
            Interval(1,4,4),
            Interval(3,5,3),
            Interval(0,6,7),
            Interval(5,8, 1),
            Interval(3,8,4),
            Interval(5,9,4),
            Interval(6,10,4),
            Interval(8,11,4),
            Interval(8,12,4),
            Interval(2,13,4),
            Interval(12,14,4))

        val output = maxIntervals.maxInterval(intervals)
        Assert.assertEquals(2, output.size)
    }
}