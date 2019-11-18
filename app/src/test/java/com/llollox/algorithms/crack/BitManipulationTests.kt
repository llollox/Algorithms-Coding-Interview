package com.llollox.algorithms.crack

import com.llollox.algorithms.problems.crack.bitmanipulation.Conversion
import com.llollox.algorithms.problems.crack.bitmanipulation.FlipBitToWin
import org.junit.Assert
import org.junit.Test

class BitManipulationTests {


    @Test
    fun flipBitToWin() {
        val flipBitToWin = FlipBitToWin()

        Assert.assertEquals(8, flipBitToWin.flipToWinBruteForce(1775))

        Assert.assertEquals(8, flipBitToWin.flipBitToWin(1775))
    }

    @Test
    fun conversionTest() {
        val conversion = Conversion()

        Assert.assertEquals(2, conversion.conversion(29, 15))
        Assert.assertEquals(2, conversion.conversion(15, 29))
        Assert.assertEquals(3, conversion.conversion(3, 4))
        Assert.assertEquals(32, conversion.conversion(0, -1))
    }
}