package previmedical.it.leetcode.unitn

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.Sorting


class SortingTest {


    @Test
    fun quickSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.quickSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

}