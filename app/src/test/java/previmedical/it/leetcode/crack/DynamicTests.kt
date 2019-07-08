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


    @Test
    fun parensTest() {

        val parens = Parens()

//        Assert.assertEquals(1, parens.generateParensRecursive(0).size)
//        Assert.assertEquals(1, parens.generateParensRecursive(1).size)
//        Assert.assertEquals(2, parens.generateParensRecursive(2).size)
//        Assert.assertEquals(5, parens.generateParensRecursive(3).size)
//        Assert.assertEquals(14, parens.generateParensRecursive(4).size)
//        Assert.assertEquals(42, parens.generateParensRecursive(5).size)
//        Assert.assertEquals(132, parens.generateParensRecursive(6).size)
//        Assert.assertEquals(429, parens.generateParensRecursive(7).size)
//        Assert.assertEquals(1430, parens.generateParensRecursive(8).size)
//        Assert.assertEquals(4862, parens.generateParensRecursive(9).size)
//        Assert.assertEquals(16796, parens.generateParensRecursive(10).size)


        Assert.assertEquals(0, parens.generateParensWithoutDupsRecursive(0).size)
        Assert.assertEquals(1, parens.generateParensWithoutDupsRecursive(1).size)
        Assert.assertEquals(2, parens.generateParensWithoutDupsRecursive(2).size)
        Assert.assertEquals(5, parens.generateParensWithoutDupsRecursive(3).size)
        Assert.assertEquals(14, parens.generateParensWithoutDupsRecursive(4).size)
        Assert.assertEquals(42, parens.generateParensWithoutDupsRecursive(5).size)
        Assert.assertEquals(132, parens.generateParensWithoutDupsRecursive(6).size)
        Assert.assertEquals(429, parens.generateParensWithoutDupsRecursive(7).size)
        Assert.assertEquals(1430, parens.generateParensWithoutDupsRecursive(8).size)
        Assert.assertEquals(4862, parens.generateParensWithoutDupsRecursive(9).size)
        Assert.assertEquals(16796, parens.generateParensWithoutDupsRecursive(10).size)
        Assert.assertEquals(742900, parens.generateParensWithoutDupsRecursive(13).size)


        Assert.assertEquals(0, parens.parensNew(0).size)
        Assert.assertEquals(1, parens.parensNew(1).size)
        Assert.assertEquals(2, parens.parensNew(2).size)
        Assert.assertEquals(5, parens.parensNew(3).size)
        Assert.assertEquals(14, parens.parensNew(4).size)
        Assert.assertEquals(42, parens.parensNew(5).size)
        Assert.assertEquals(132, parens.parensNew(6).size)
        Assert.assertEquals(429, parens.parensNew(7).size)
        Assert.assertEquals(1430, parens.parensNew(8).size)
        Assert.assertEquals(4862, parens.parensNew(9).size)
        Assert.assertEquals(16796, parens.parensNew(10).size)
        Assert.assertEquals(742900, parens.parensNew(13).size)


        Assert.assertEquals(0, parens.parensWithoutDupsNew(0).size)
        Assert.assertEquals(1, parens.parensWithoutDupsNew(1).size)
        Assert.assertEquals(2, parens.parensWithoutDupsNew(2).size)
        Assert.assertEquals(5, parens.parensWithoutDupsNew(3).size)
        Assert.assertEquals(14, parens.parensWithoutDupsNew(4).size)
        Assert.assertEquals(42, parens.parensWithoutDupsNew(5).size)
        Assert.assertEquals(132, parens.parensWithoutDupsNew(6).size)
        Assert.assertEquals(429, parens.parensWithoutDupsNew(7).size)
        Assert.assertEquals(1430, parens.parensWithoutDupsNew(8).size)
        Assert.assertEquals(4862, parens.parensWithoutDupsNew(9).size)
        Assert.assertEquals(16796, parens.parensWithoutDupsNew(10).size)
        Assert.assertEquals(742900, parens.parensWithoutDupsNew(13).size)
    }

    @Test
    fun coinsTest() {
        val coins = Coins()

        Assert.assertEquals(0, coins.coins(0))
        Assert.assertEquals(1, coins.coins(1))
        Assert.assertEquals(2, coins.coins(5))
        Assert.assertEquals(4, coins.coins(10))
        Assert.assertEquals(9, coins.coins(20))
        Assert.assertEquals(13, coins.coins(25))
        Assert.assertEquals(242, coins.coins(100))
        Assert.assertEquals(142511, coins.coins(1000))
        Assert.assertEquals(134235101, coins.coins(10000))

        Assert.assertEquals(0, coins.coinsVector(0))
        Assert.assertEquals(1, coins.coinsVector(1))
        Assert.assertEquals(2, coins.coinsVector(5))
        Assert.assertEquals(4, coins.coinsVector(10))
        Assert.assertEquals(9, coins.coinsVector(20))
        Assert.assertEquals(13, coins.coinsVector(25))
        Assert.assertEquals(242, coins.coinsVector(100))
        Assert.assertEquals(142511, coins.coinsVector(1000))
        Assert.assertEquals(134235101, coins.coinsVector(10000))

        Assert.assertEquals(0, coins.coinsMemo(0))
        Assert.assertEquals(1, coins.coinsMemo(1))
        Assert.assertEquals(2, coins.coinsMemo(5))
        Assert.assertEquals(4, coins.coinsMemo(10))
        Assert.assertEquals(9, coins.coinsMemo(20))
        Assert.assertEquals(13, coins.coinsMemo(25))
        Assert.assertEquals(242, coins.coinsMemo(100))
        Assert.assertEquals(142511, coins.coinsMemo(1000))
        Assert.assertEquals(134235101, coins.coinsMemo(10000))
    }

    @Test
    fun eightQueensTest() {
        val eightQueens = EightQueens()

        val output = eightQueens.eightQueens(8)


        Assert.assertEquals(8, output.size)
        val list = output.toMutableList()

        (0 until list.size).forEach {
            val point = list[it]
            list.remove(point)
            val set = list.toSet()
            Assert.assertEquals(true, eightQueens.canBePlaced(set, point))
            list.add(point)
        }
    }
}