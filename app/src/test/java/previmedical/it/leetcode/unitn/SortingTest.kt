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
    fun countingSortTest() {

        val sorting = Sorting()

        val input1 = intArrayOf(12, 4, 9, 18, 2, 0, -5, 29, 1)
        val output1 = sorting.countingSort(input1)
        val expected1 = intArrayOf(-5, 0, 1, 2, 4, 9, 12, 18, 29)

        Assert.assertEquals(true, output1!!.contentEquals(expected1))

        val input = intArrayOf(3, 2, 1, 1, 4, 2, 0)
        val output = sorting.countingSort(input)
        val expected = intArrayOf(0, 1, 1, 2, 2, 3, 4)

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
    fun radixSortTest() {

        val sorting = Sorting()

        val input1 = intArrayOf(12, 4, 9, 18, 2, 0, 0, 29, 1)
        val output1 = sorting.radixSort(input1)
        val expected1 = intArrayOf(0, 0, 1, 2, 4, 9, 12, 18, 29)

        Assert.assertEquals(true, output1!!.contentEquals(expected1))
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