package previmedical.it.leetcode.crack

import android.util.Log
import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.models.Point
import previmedical.it.leetcode.problems.crack.moderate.*

class ModerateTests {

    @Test
    fun swapNumbers() {

        val swapNumbers = SwapNumbers()

        val swap1 = swapNumbers.swapNumbers(SwapNumbers.Swap(1, 2))
        Assert.assertEquals(2, swap1.a)
        Assert.assertEquals(1, swap1.b)

        val swap2 = swapNumbers.swapNumbers(SwapNumbers.Swap(5, 2))
        Assert.assertEquals(2, swap2.a)
        Assert.assertEquals(5, swap2.b)

        val swap3 = swapNumbers.swapNumbers(SwapNumbers.Swap(-2, -3))
        Assert.assertEquals(-3, swap3.a)
        Assert.assertEquals(-2, swap3.b)
    }


    @Test
    fun intersection() {

        val p1a = Point(2,4)
        val p1b = Point(4,8)

        val p2a = Point(-1,0)
        val p2b = Point(3,4)

        val intersection = Intersection()

        Assert.assertEquals(2, intersection.gradient(p1a, p1b))
        Assert.assertEquals(1, intersection.gradient(p2a, p2b))

        val output = intersection.intersection(p1a, p1b, p2a, p2b)

        Log.w("ouput", "test")
    }


    @Test
    fun numberMax() {

        val a = Integer.MAX_VALUE -2
        val b = -10

        val output = NumberMax().max(a, b)
        Assert.assertEquals(a, output)
    }

    @Test
    fun factorialZero() {

        val factorial = FactorialZero()

        Assert.assertEquals(2, factorial.trailingZero(10))
        Assert.assertEquals(4, factorial.trailingZero(20))
    }


    @Test
    fun smallestDifference() {
        val a = intArrayOf(1, 3, 15, 11, 2)
        val b = intArrayOf(23, 127, 235, 19, 8)

        val smallestDifference = SmallestDifference()

        Assert.assertEquals(3, smallestDifference.naive(a,b))
        Assert.assertEquals(3, smallestDifference.binarySearch(a,b))
        Assert.assertEquals(3, smallestDifference.twoPointers(a,b))
    }

    @Test
    fun livingPeople() {

        val people = arrayOf(
            LivingPeople.Person(1923, 2000),
            LivingPeople.Person(1930, 1984),
            LivingPeople.Person(1991, 1999),
            LivingPeople.Person(1954, 1989),
            LivingPeople.Person(1960, 1984),
            LivingPeople.Person(1943, 1965))

        val livingPeople = LivingPeople()

        Assert.assertEquals(1960, livingPeople.bruteForce(people))
        Assert.assertEquals(1960, livingPeople.sorted(people))
        Assert.assertEquals(1960, livingPeople.optimum(people))
    }

    @Test
    fun masterMind() {

        val masterMind = MasterMind()
        val pattern = charArrayOf('R', 'G', 'B', 'Y')
        val solution = charArrayOf('G', 'G', 'R', 'R')

        val output = masterMind.countHits(pattern, solution)
        Assert.assertEquals(1, output.numHits)
        Assert.assertEquals(1, output.numPseudoHits)
    }

    @Test
    fun subSort() {
        val subSort = SubSort()
        val input = intArrayOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)
        val output = subSort.getSub(input)
        Assert.assertEquals(3, output.m)
        Assert.assertEquals(9, output.n)
    }

    @Test
    fun contiguousSum() {
        val contiguousSum = ContiguousSum()
        val input = intArrayOf(2, -8, 3, -2, 4, -10)
        val output = contiguousSum.getMaximumSum(input)
        Assert.assertEquals(5, output)
    }

    @Test
    fun pondSizes() {
        val pondSize = PondSizes()
        val input = arrayOf(
                intArrayOf(0, 2, 1, 0),
                intArrayOf(0, 1, 0, 1),
                intArrayOf(1, 1, 0, 1),
                intArrayOf(0, 1, 0, 1))
        val output = pondSize.getPondSizes(input)
        Assert.assertEquals(3, output.size)
        Assert.assertEquals(2, output[0])
        Assert.assertEquals(4, output[1])
        Assert.assertEquals(1, output[2])
    }
}