package previmedical.it.leetcode.other

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import previmedical.it.leetcode.problems.crack.hard.Count2s
import previmedical.it.leetcode.problems.other.NumSubsets
import previmedical.it.leetcode.problems.other.Sudoku

class OtherTest {


    @Test
    fun sudokuTest() {
        val sudoku = Sudoku()
        val matrix = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0))

        sudoku.sudoku(matrix)

        Assert.assertEquals(sudoku.isValidMatrix(matrix), true)
    }

    @Test
    fun numSubsetsTest() {
        val numSubsets = NumSubsets()
        assertEquals(2, numSubsets.numSubsets(intArrayOf(2,4,6,10), 16))
        assertEquals(90, numSubsets.numSubsets(intArrayOf(
            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1),
            103))

        assertEquals(90, numSubsets.numSubsetsWithMemoization(intArrayOf(
            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1, 2,4,6,10, 1, 2,4,6,10, 1),
            103))
    }

    @Test
    fun numSubsetsWithMemoizationTest() {
        val numSubsets = NumSubsets()
        assertEquals(90, numSubsets.numSubsetsWithMemoization(intArrayOf(
            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1, 2,4,6,10),
            103))
    }

    @Test
    fun count2sTest() {
        val count2s = Count2s()
        assertEquals(1, count2s.count2s(2))
        assertEquals(0, count2s.count2s(0))
        assertEquals(0, count2s.count2s(1))
        assertEquals(1, count2s.count2s(7))
        assertEquals(2, count2s.count2s(12))
        assertEquals(2, count2s.count2s(13))
        assertEquals(3, count2s.count2s(20))
        assertEquals(13, count2s.count2s(30))
        assertEquals(15, count2s.count2s(50))
        assertEquals(20, count2s.count2s(100))

        assertEquals(1, count2s.count2sInRange(2))
        assertEquals(0, count2s.count2sInRange(0))
        assertEquals(0, count2s.count2sInRange(1))
        assertEquals(1, count2s.count2sInRange(7))
        assertEquals(2, count2s.count2sInRange(12))
        assertEquals(2, count2s.count2sInRange(13))
        assertEquals(3, count2s.count2sInRange(20))
        assertEquals(13, count2s.count2sInRange(30))
        assertEquals(15, count2s.count2sInRange(50))
        assertEquals(20, count2s.count2sInRange(100))

        assertEquals(34507, count2s.count2s(61523))
        assertEquals(34507, count2s.count2sInRange(61523))
    }
}