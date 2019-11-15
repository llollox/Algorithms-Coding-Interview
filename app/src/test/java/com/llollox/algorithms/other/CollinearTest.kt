package com.llollox.algorithms.other

import com.llollox.algorithms.problems.other.Collinear
import org.junit.Assert
import org.junit.Test

class CollinearTest {

    private val collinear = Collinear()

    @Test
    fun withEmptyInput__shouldReturnZero() {
        val output = this.collinear.getCollinear(listOf(), 2)
        Assert.assertEquals(0, output.size)
    }

    @Test
    fun with1Point__shouldReturnZero() {
        val p1 = Collinear.Point(0, 0)
        val output = this.collinear.getCollinear(listOf(p1), 1)
        Assert.assertEquals(0, output.size)
    }

    @Test
    fun withOneLineOfPoints__shouldReturnOne() {
        val p1 = Collinear.Point(0, 0)
        val p2 = Collinear.Point(0, 1)
        val p3 = Collinear.Point(0, 2)
        val output = this.collinear.getCollinear(listOf(p1, p2, p3), 3)
        Assert.assertEquals(1, output.size)
    }

    @Test
    fun withTwoLineOfPoints__shouldReturnTwo() {
        val p1 = Collinear.Point(0, 0)
        val p2 = Collinear.Point(0, 1)
        val p3 = Collinear.Point(0, 2)
        val p4 = Collinear.Point(-1, 1)
        val p5 = Collinear.Point(1, 1)
        val output = this.collinear.getCollinear(listOf(p1, p2, p3, p4, p5), 3)
        Assert.assertEquals(2, output.size)
    }


    @Test
    fun withTwoLinesOf4__whenNIs4__shouldReturnTwo() {
        val p1 = Collinear.Point(3, 0)
        val p2 = Collinear.Point(4, 1)
        val p3 = Collinear.Point(5, 2)
        val p4 = Collinear.Point(6, 3)

        val p5 = Collinear.Point(2, 8)
        val p6 = Collinear.Point(3, 6)
        val p7 = Collinear.Point(4, 4)

        val output = this.collinear.getCollinear(listOf(p1, p2, p3, p4, p5, p6, p7), 4)
        Assert.assertEquals(2, output.size)
    }

    @Test
    fun withTwoLinesOf4__withNoisePoints__whenNIs4__shouldReturnTwo() {
        val p1 = Collinear.Point(3, 0)
        val p2 = Collinear.Point(4, 1)
        val p3 = Collinear.Point(5, 2)
        val p4 = Collinear.Point(6, 3)

        val p5 = Collinear.Point(2, 8)
        val p6 = Collinear.Point(3, 6)
        val p7 = Collinear.Point(4, 4)

        val p9 = Collinear.Point(-1, 1)
        val p10 = Collinear.Point(1, 1)
        val p11 = Collinear.Point(8, 8)
        val p12 = Collinear.Point(3, 8)
        val output = this.collinear.getCollinear(listOf(p1, p2, p3, p4, p5, p6, p7, p9, p10, p11, p12), 4)
        Assert.assertEquals(2, output.size)
    }


}