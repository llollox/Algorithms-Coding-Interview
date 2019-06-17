package previmedical.it.leetcode.crack

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.problems.crack.strings.IsPermutation
import previmedical.it.leetcode.problems.crack.strings.IsUnique

class StringTests {


    @Test
    fun isUniqueTests() {
        val isUnique = IsUnique()
        Assert.assertEquals(true, isUnique.isUnique("ciao"))
        Assert.assertEquals(true, isUnique.isUnique("ciaone"))
        Assert.assertEquals(false, isUnique.isUnique("ciaooo"))
        Assert.assertEquals(false, isUnique.isUnique("ciaozz"))
    }

    @Test
    fun toggleTests() {
        val isUnique = IsUnique()
        Assert.assertEquals(2, isUnique.toggle(0, 1))
        Assert.assertEquals(32, isUnique.toggle(0, 5))
        Assert.assertEquals(256, isUnique.toggle(0, 8))
        Assert.assertEquals(0, isUnique.toggle(2, 1))
        Assert.assertEquals(256, isUnique.toggle(258, 1))
        Assert.assertEquals(2, isUnique.toggle(258, 8))
    }

    @Test
    fun isPermutationTests() {
        val isPermutation = IsPermutation()
        Assert.assertEquals(true, isPermutation.isPermutation("ciao", "iaoc"))
        Assert.assertEquals(true, isPermutation.isPermutation("ciaoaaa", "iaaocaa"))
        Assert.assertEquals(false, isPermutation.isPermutation("provaaa", "prov"))
        Assert.assertEquals(false, isPermutation.isPermutation("", "iaoc"))
    }

}