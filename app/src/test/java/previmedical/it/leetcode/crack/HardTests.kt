package previmedical.it.leetcode.crack

import org.junit.Assert.assertEquals
import org.junit.Test
import previmedical.it.leetcode.problems.crack.hard.*

class HardTests {

    @Test
    fun addWithoutPlus() {
        val addWithoutPlus = AddWithoutPlus()
        assertEquals(14, addWithoutPlus.addWithoutPlus(5, 9))
        assertEquals(81, addWithoutPlus.addWithoutPlus(72, 9))
        assertEquals(14, addWithoutPlus.addWithoutPlus(3, 11))
        assertEquals(30, addWithoutPlus.addWithoutPlus(15, 15))
        assertEquals(200118, addWithoutPlus.addWithoutPlus(100038, 100080))
    }

    @Test
    fun shuffleDeckTest() {
        val shuffleDeck = ShuffleDeck()
        val deck = ((0..51).toList()).toIntArray()
        val shuffled = shuffleDeck.shuffle(deck)
        assertEquals(52, shuffled.size)
    }

    @Test
    fun randomSetTest() {
        val randomSet = RandomSet()
        val output = randomSet.randomSet(intArrayOf(1,2,3,4,5,6,7,8,9,10), 5)
        assertEquals(5, output.size)
    }

    @Test
    fun lettersAndNumbersTest() {
        val lettersAndNumbers = LettersAndNumbers()
        val array = charArrayOf('r', '1', 'a', 'c', '2', '3', 'q', 'q', 'r')
        val output = lettersAndNumbers.lettersAndNumbers(array)
        assertEquals(6, output.size)
    }

    @Test
    fun babyNamesTest() {
        val babyNames = BabyNames()
        val babyNamesMap = mapOf(Pair("John", 15), Pair("Jon", 12), Pair("Chris", 13), Pair("Kris", 4), Pair("Christopher", 19))
        val synonyms = listOf(Pair("Jon", "John"), Pair("John", "Johnny"), Pair("Chris", "Kris"), Pair("Chris", "Christopher"))
        val output = babyNames.babyNames(babyNamesMap, synonyms)
        assertEquals(2, output.size)
        assertEquals(27, output["Jon"])
        assertEquals(36, output["Chris"])
    }
}