package previmedical.it.leetcode.crack

import org.junit.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.crack.bitmanipulation.FlipBitToWin

class BitManipulationTests {


    @Test
    fun flipBitToWin() {
        val flipBitToWin = FlipBitToWin()

        Assert.assertEquals(8, flipBitToWin.flipToWinBruteForce(1775))

        Assert.assertEquals(8, flipBitToWin.flipBitToWin(1775))
    }
}