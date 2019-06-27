package previmedical.it.leetcode.crack

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.crack.dynamic.*

class DynamicTests {


    @Test
    fun tripleStepsRecursiveTest() {

        val tripleSteps = TripleSteps()
        Assert.assertEquals(7, tripleSteps.tripleStepRecursive(4))
        Assert.assertEquals(274, tripleSteps.tripleStepRecursive(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepRecursive(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepRecursive(35))


        Assert.assertEquals(7, tripleSteps.tripleStepMemoization(4))
        Assert.assertEquals(274, tripleSteps.tripleStepMemoization(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepMemoization(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepMemoization(35))


        Assert.assertEquals(7, tripleSteps.tripleStepDynamicProgramming(4))
        Assert.assertEquals(274, tripleSteps.tripleStepDynamicProgramming(10))
        Assert.assertEquals(2555757, tripleSteps.tripleStepDynamicProgramming(25))
        Assert.assertEquals(1132436852, tripleSteps.tripleStepDynamicProgramming(35))

    }


    @Test
    fun robotInGridTest() {

        val G = arrayOf(
            booleanArrayOf(true, true, false, true),
            booleanArrayOf(false, true, true, false),
            booleanArrayOf(true, false, true, true))

        val robotInGrid = RobotIntoGrid()
        val points = robotInGrid.robotInGrid(G)

        Assert.assertEquals(6, points.size)
        Assert.assertEquals(0, points[0].x)
        Assert.assertEquals(0, points[0].y)

        Assert.assertEquals(3, points[5].x)
        Assert.assertEquals(2, points[5].y)


        val pointsMemoization = robotInGrid.robotIntoGridMemoization(G)

        Assert.assertEquals(6, pointsMemoization.size)
        Assert.assertEquals(0, pointsMemoization[0].x)
        Assert.assertEquals(0, pointsMemoization[0].y)

        Assert.assertEquals(3, pointsMemoization[5].x)
        Assert.assertEquals(2, pointsMemoization[5].y)
    }

    @Test
    fun magicIndexTest() {

        val input1 = intArrayOf(-1, 0, 5, 6, 7, 8)
        val input2 = intArrayOf(-2, 0, 2)
        val input3 = intArrayOf(-12, -8, -2, 0, 1, 3, 5, 7, 11, 19)

        val magicIndex = MagicIndex()

        Assert.assertEquals(-1, magicIndex.magicIndexBruteForce(input1))
        Assert.assertEquals(2, magicIndex.magicIndexBruteForce(input2))
        Assert.assertEquals(7, magicIndex.magicIndexBruteForce(input3))

        Assert.assertEquals(-1, magicIndex.magicIndexBinarySearch(input1))
        Assert.assertEquals(2, magicIndex.magicIndexBinarySearch(input2))
        Assert.assertEquals(7, magicIndex.magicIndexBinarySearch(input3))

        Assert.assertEquals(-1, magicIndex.magicIndexBinarySearchIterative(input1))
        Assert.assertEquals(2, magicIndex.magicIndexBinarySearchIterative(input2))
        Assert.assertEquals(7, magicIndex.magicIndexBinarySearchIterative(input3))


    }

    @Test
    fun magicIndexDuplicatesTest() {

        val input1 = intArrayOf(-1, 0, 0, 4, 7, 8)
        val input2 = intArrayOf(-2, 0, 2)
        val input3 = intArrayOf(-12, -8, -8, -8, -7, 3, 5, 7, 11, 19)

        val magicIndex = MagicIndex()

        Assert.assertEquals(-1, magicIndex.magicIndexDuplicates(input1))
        Assert.assertEquals(2, magicIndex.magicIndexDuplicates(input2))
        Assert.assertEquals(7, magicIndex.magicIndexDuplicates(input3))
    }

    @Test
    fun powerSetTest() {

        val input1 = listOf(1, 2, 3)

        val powerSet = PowerSet()

        val ouptut1 = powerSet.powerSetIterative(input1)
        Assert.assertEquals(8, ouptut1.size)
        Assert.assertEquals(0, ouptut1[0].size)

        val ouptut11 = powerSet.powerSetRecursive(input1)
        Assert.assertEquals(8, ouptut11.size)
        Assert.assertEquals(0, ouptut11[0].size)
    }

    @Test
    fun recursiveMultiplyTest() {

        val recursiveMultiply = RecursiveMultiply()

//        Assert.assertEquals(0, recursiveMultiply.recursiveMultiply(12, 0))
//        Assert.assertEquals(56, recursiveMultiply.recursiveMultiply(8, 7))
//        Assert.assertEquals(144, recursiveMultiply.recursiveMultiply(12, 12))
//        Assert.assertEquals(169, recursiveMultiply.recursiveMultiply(13, 13))
//        Assert.assertEquals(124, recursiveMultiply.recursiveMultiply(31, 4))

//        Assert.assertEquals(0, recursiveMultiply.recursiveMultiply2(12, 0))
        Assert.assertEquals(56, recursiveMultiply.recursiveMultiply2(8, 7))
        Assert.assertEquals(144, recursiveMultiply.recursiveMultiply2(12, 12))
        Assert.assertEquals(169, recursiveMultiply.recursiveMultiply2(13, 13))
        Assert.assertEquals(124, recursiveMultiply.recursiveMultiply2(31, 4))
    }


    @Test
    fun permutationsTest() {
        val permutations = PermutationsWithoutDups()
        val output = permutations.permutations("cip")
        Assert.assertEquals(8, output.size)

    }
}