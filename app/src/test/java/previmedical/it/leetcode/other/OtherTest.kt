package previmedical.it.leetcode.other

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import previmedical.it.leetcode.problems.crack.hard.Count2s
import previmedical.it.leetcode.problems.other.NumSubsets
import previmedical.it.leetcode.problems.other.NumWaysToDecode
import previmedical.it.leetcode.problems.other.SortSubSequences
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





    @Test
    fun sortSubSequenceTest() {
        val sortSubSequence = SortSubSequences()
        val input1 = listOf(intArrayOf(1, 9, 5), intArrayOf(1, 3, 9))
        val output1 = sortSubSequence.sortSubSequences(input1)
        assertEquals( 4, output1.size)
        assertEquals( 1, output1[0])
        assertEquals( 3, output1[1])
        assertEquals( 9, output1[2])
        assertEquals( 5, output1[3])

        val input2 = listOf(intArrayOf(1), intArrayOf(2))
        val output2 = sortSubSequence.sortSubSequences(input2)
        assertEquals( 2, output2.size)

        val input3 = listOf(intArrayOf(1, 2), intArrayOf(2, 1))
        val output3 = sortSubSequence.sortSubSequences(input3)
        assertEquals( null, output3)
    }

    @Test
    fun numWaysToDecodeTest() {
        val numWaysToDecode = NumWaysToDecode()
        assertEquals(2, numWaysToDecode.numWays("12"))
        assertEquals(5, numWaysToDecode.numWays("1212")) // abab, abl, lab, ll, aub
    }
}