package previmedical.it.leetcode.unitn

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.Sorting


class SortingTest {


    @Test
    fun bubbleSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.bubbleSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

    @Test
    fun heapSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.heapSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

    @Test
    fun insertionSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.insertionSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

    @Test
    fun mergeSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.mergeSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

    @Test
    fun quickSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.quickSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

    @Test
    fun selectionSortTest() {

        val sorting = Sorting()

        val input = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output = sorting.selectionSort(input)
        val expected = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)
        Assert.assertEquals(true, output!!.contentEquals(expected))
    }

}