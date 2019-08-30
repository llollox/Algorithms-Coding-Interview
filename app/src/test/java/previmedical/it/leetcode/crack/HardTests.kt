package previmedical.it.leetcode.crack

import org.junit.Assert.assertArrayEquals
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

    @Test
    fun babyNamesGraphTest() {
        val babyNames = BabyNames()
        val babyNamesMap = mapOf(Pair("John", 15), Pair("Jon", 12), Pair("Chris", 13), Pair("Kris", 4), Pair("Christopher", 19))
        val synonyms = listOf(Pair("Jon", "John"), Pair("John", "Johnny"), Pair("Chris", "Kris"), Pair("Chris", "Christopher"))
        val output = babyNames.babyNamesGraph(babyNamesMap, synonyms)
        assertEquals(2, output.size)
        assertEquals(27, output["Johnny"])
        assertEquals(36, output["Kris"])
    }

    @Test
    fun circusTowerTest() {
        val people = listOf(
            CircusTower.Person(189, 98),
            CircusTower.Person(170, 100),
            CircusTower.Person(198, 70),
            CircusTower.Person(182, 78),
            CircusTower.Person(200, 110))

        val circusTower = CircusTower()
        val output = circusTower.longestIncreasingSeq(people)

        assertEquals(3, output.size)
    }

    @Test
    fun kthMultiple() {
        val kthMultiple = KthMultiple()
        assertEquals(-1, kthMultiple.kthMultiple(0))
        assertEquals(1, kthMultiple.kthMultiple(1))
        assertEquals(3, kthMultiple.kthMultiple(2))
        assertEquals(5, kthMultiple.kthMultiple(3))
        assertEquals(7, kthMultiple.kthMultiple(4))
        assertEquals(9, kthMultiple.kthMultiple(5))
        assertEquals(15, kthMultiple.kthMultiple(6))
        assertEquals(21, kthMultiple.kthMultiple(7))
        assertEquals(25, kthMultiple.kthMultiple(8))
        assertEquals(27, kthMultiple.kthMultiple(9))
        assertEquals(24111675, kthMultiple.kthMultiple(1000))
    }

    @Test
    fun majorityElementNaiveTest() {
        val majorityElement = MajorityElement()
        assertEquals(5, majorityElement.majorityElementNaive(intArrayOf(1, 2, 5, 9, 5, 9, 5, 5, 5)))
        assertEquals(3, majorityElement.majorityElementNaive(intArrayOf(1, 2, 3, 3, 3, 3, 9)))
    }

    @Test
    fun majorityElementTest() {
        val majorityElement = MajorityElement()
        assertEquals(5, majorityElement.majorityElement(intArrayOf(1, 2, 5, 9, 5, 9, 5, 5, 5)))
        assertEquals(3, majorityElement.majorityElement(intArrayOf(1, 2, 3, 3, 3, 3, 9)))
        assertEquals(-1, majorityElement.majorityElement(intArrayOf(1, 10, 100)))
        assertEquals(10, majorityElement.majorityElement(intArrayOf(1, 10, 10, 10, 100)))
    }

    @Test
    fun wordDistance() {
        val wordDistance = WordDistance()
        val input = arrayOf("Prova", "Test", "Testolino", "Perdincibacco", "Test", "Perdinci", "Test", "Pass", "Prova")
        assertEquals(1, wordDistance.wordDistance(input, "Test", "Pass"))
        assertEquals(1, wordDistance.wordDistance(input, "Test", "Prova"))
        assertEquals(0, wordDistance.wordDistance(input, "Test", "Test"))
    }

    @Test
    fun smallestK_Heap_Test() {
        val smallestK = SmallestK()
        assertArrayEquals(intArrayOf(4, 2, 1), smallestK.smallestK_Heap(intArrayOf(1, 7, 18, 2, 4, 6), 3))
        assertArrayEquals(intArrayOf(2, 1), smallestK.smallestK_Heap(intArrayOf(1, 7, 18, 2, 4, 6), 2))
        assertArrayEquals(intArrayOf(1), smallestK.smallestK_Heap(intArrayOf(1, 7, 18, 2, 4, 6), 1))
    }

    @Test
    fun smallestK_Partitioning_Test() {
        val smallestK = SmallestK()
        assertArrayEquals(intArrayOf(4, 2, 1), smallestK.smallestK_Partitioning(intArrayOf(1, 7, 18, 2, 4, 6), 3))
        assertArrayEquals(intArrayOf(2, 1), smallestK.smallestK_Partitioning(intArrayOf(1, 7, 18, 2, 4, 6), 2))
        assertArrayEquals(intArrayOf(1), smallestK.smallestK_Partitioning(intArrayOf(1, 7, 18, 2, 4, 6), 1))
        assertArrayEquals(intArrayOf(2, 1, 1, 1), smallestK.smallestK_Partitioning(intArrayOf(1, 1, 1, 7, 18, 2, 4, 6), 4))
    }

    @Test
    fun canBeBuilt_Test() {
        val longestWord = LongestWord()
        val words = setOf("test", "ing", "prova", "computer", "telephone", "testing")
        assertEquals(true, longestWord.canBeBuilt("computertesting", words))
        assertEquals(true, longestWord.canBeBuilt("testingcomputer", words))

        assertEquals("testing", longestWord.longestWord(words))
    }

    @Test
    fun masseuseTest() {
        val masseuse = Masseuse()
        val input = intArrayOf(30, 15, 60, 75, 45, 15, 15, 45)
        assertEquals(180, masseuse.maxMinutes(input))

        val input1 = intArrayOf(30, 15, 60, 75, 45, 15, 15, 45, 30, 15, 60, 75, 45, 15, 15, 45, 30, 15, 60, 75, 45, 15, 15, 45, 75, 45, 15, 15, 45, 30, 15, 60, 75, 45, 15, 15, 45, 75, 45, 15, 15, 45, 30)
        assertEquals(840, masseuse.maxMinutes(input1))


        assertEquals(180, masseuse.maxMinutesIterative(input))
        assertEquals(840, masseuse.maxMinutesIterative(input1))

        assertEquals(180, masseuse.maxMinutesIterativeOptimal(input))
        assertEquals(840, masseuse.maxMinutesIterativeOptimal(input1))
    }

    @Test
    fun shortestSubsequenceTest() {
        val shortestSubsequence = ShortestSubsequence()
        val inputLonger = intArrayOf(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7)
        val inputShorter = intArrayOf(1, 5, 9)
        val output = shortestSubsequence.shortestSubsequence(inputLonger, inputShorter)
        assertEquals(2, output.size)
        assertEquals(7, output[0])
        assertEquals(10, output[1])
    }

    @Test
    fun missingTwoTest() {
        val missingTwo = MissingTwo()
        val input = intArrayOf(2, 8, 4, 1, 9, 6, 5)
        val output = missingTwo.missingTwo(input)
        assertEquals(7, output[0])
        assertEquals(3, output[1])
    }

    @Test
    fun missingTwoEdgeTest() {
        val missingTwo = MissingTwo()
        val input = intArrayOf()
        val output = missingTwo.missingTwo(input)
        assertEquals(2, output[0])
        assertEquals(1, output[1])
    }

    @Test
    fun continuousMedianTest() {
        val continuousMedian = ContinuousMedian()
        assertEquals(0, continuousMedian.median)
        continuousMedian.addValue(1)
        assertEquals(1, continuousMedian.median)
        continuousMedian.addValue(2)
        assertEquals(1, continuousMedian.median)
        continuousMedian.addValue(3)
        assertEquals(2, continuousMedian.median)
        continuousMedian.addValue(3)
        assertEquals(2, continuousMedian.median)
        continuousMedian.addValue(3)
        assertEquals(3, continuousMedian.median)
    }

    @Test
    fun volumeHistogramTest() {
        val volumeOfHistogram = VolumeOfHistogram()
        val input = intArrayOf(0,0,4,0,0,6,0,0, 3,0, 5,0,1,0,0,0)
        assertEquals(26, volumeOfHistogram.volumeHistogram(input))

        val input2 = intArrayOf(0,0,4,0,0,6,0,0,3,0,8,0,2,0,5,2,0,3,0,0)
        assertEquals(46, volumeOfHistogram.volumeHistogram(input2))
    }

    @Test
    fun trieTest() {
        val trie = MultiSearch.Trie()
        trie.addWord("is")
        trie.addWord("ppi")
        trie.addWord("hi")
        trie.addWord("sis")
        trie.addWord("i")
        trie.addWord("ssippi")

        assertEquals(true, trie.contains("sis"))
        assertEquals(false, trie.contains("sisd"))
    }

    @Test
    fun multiSearchTest() {
        val multiSearch = MultiSearch()
        val words = listOf("is", "ppi", "hi", "sis", "i", "ssippi")
        val output = multiSearch.multiSearch("mississippi", words)
        assertEquals(5, output.size)
    }

    @Test
    fun wordTransformerDFSTest() {
        val wordTransformer = WordTransformer()
        val dictionary = arrayOf("DAMP","DAKP", "DAKE", "CAKE", "CIKE", "PIKE", "SIKE", "CINE", "LAKE", "LAMP","LIMP","LIME","LIKE")
        val output = wordTransformer.wordTransformerDFS("DAMP", "LIKE", dictionary)
        assertEquals(8, output.size)
    }

    @Test
    fun wordTransformerBFSTest() {
        val wordTransformer = WordTransformer()
        val dictionary = arrayOf("DAMP","DAKP", "DAKE", "CAKE", "CIKE", "PIKE", "SIKE", "CINE", "LAKE", "LAMP","LIMP","LIME","LIKE")
        val output = wordTransformer.wordTransformerBFS("DAMP", "LIKE", dictionary)
        assertEquals(5, output.size)
    }

    @Test
    fun wordTransformerOptmialTest() {
        val wordTransformer = WordTransformer()
        val dictionary = arrayOf("DAMP","DAKP", "DAKE", "LAKE","LAMP","LIMP","LIME","LIKE")
        val output = wordTransformer.transform("DAMP", "LIKE", dictionary)
        assertEquals(5, output.size)
    }

    @Test
    fun maxSquareMatrixTest() {
        val input = arrayOf(
            intArrayOf(1, 0, 0, 0, 1, 0),
            intArrayOf(1, 0, 1, 0, 1, 1),
            intArrayOf(0, 0, 0, 0, 1, 1),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 0, 1, 0),
            intArrayOf(1, 1, 0, 0, 1, 1)
        )
        val maxSquareMatrix = MaxSquareMatrix()
        val output = maxSquareMatrix.maxSquare(input)
        assertEquals(0, output.i)
        assertEquals(1, output.j)
        assertEquals(3, output.length)
    }
}