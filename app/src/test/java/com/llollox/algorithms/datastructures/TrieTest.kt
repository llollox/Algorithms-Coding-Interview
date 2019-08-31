package com.llollox.algorithms.datastructures

import org.junit.Assert
import org.junit.Test
import com.llollox.algorithms.datastructure.trie.Trie

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

}