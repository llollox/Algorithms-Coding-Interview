package previmedical.it.leetcode.other

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
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
//        assertEquals(90, numSubsets.numSubsets(intArrayOf(
//            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1),
//            103))

        assertEquals(90, numSubsets.numSubsetsWithMemoization(intArrayOf(
            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1, 2,4,6,10, 1, 2,4,6,10, 1),
            103))

//        assertEquals(90, numSubsets.numSubsetsWithMemoization(intArrayOf(
//            2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 2,4,6,10, 1, 2,4,6,10),
//            103))
    }
}