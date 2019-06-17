package previmedical.it.leetcode.unitn

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.unitn.KnightDialer


class UnitnTest  {

    @Test
    fun knightDialer() {

        val knightDialer = KnightDialer()

//        Assert.assertEquals(1, knightDialer.knightDialer(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialer(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialer(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialer(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialer(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialer(1, 50))
//
//        Assert.assertEquals(1, knightDialer.knightDialerRecursive(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialerRecursive(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialerRecursive(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialerRecursive(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialerRecursive(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialerRecursive(1, 50))
//
//        Assert.assertEquals(1, knightDialer.knightDialerDp(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialerDp(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialerDp(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialerDp(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialerDp(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialerDp(1, 50))

//
        System.out.println(System.currentTimeMillis())
        Assert.assertEquals(1912111104, knightDialer.knightDialerRecursive(1, 30))
        System.out.println(System.currentTimeMillis())

        System.out.println("------------------------------------")

        System.out.println(System.currentTimeMillis())
        Assert.assertEquals(1912111104, knightDialer.knightDialerDp(1, 30))
        System.out.println(System.currentTimeMillis())
    }

}
