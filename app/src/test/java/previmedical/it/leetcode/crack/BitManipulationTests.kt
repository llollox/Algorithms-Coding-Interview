package previmedical.it.leetcode.crack

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.crack.bitmanipulation.Conversion
import previmedical.it.leetcode.problems.crack.bitmanipulation.FlipBitToWin

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