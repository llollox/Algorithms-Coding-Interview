package com.llollox.algorithms.datastructures

import com.llollox.algorithms.datastructure.trie.Trie
import org.junit.Assert
import org.junit.Test

class TrieTest {

    @Test
    fun trieTest() {
        val input = listOf("Ciao", "come", "stai", "Tutto", "bene", "tu")
        val trie = Trie(input)
        Assert.assertEquals(false, trie.contains("ciao", false))
        Assert.assertEquals(true, trie.contains("Ciao", false))
        Assert.assertEquals(true, trie.contains("Cia", false))
        Assert.assertEquals(false, trie.contains("Cia", true))
    }

    @Test
    fun trie2Test() {
        val dictionary = listOf("looked", "just", "like", "her", "brother")
        val trie = Trie(dictionary)
        Assert.assertEquals(true, trie.contains("like", true))
        Assert.assertEquals(true, trie.contains("looked", true))
    }

}
