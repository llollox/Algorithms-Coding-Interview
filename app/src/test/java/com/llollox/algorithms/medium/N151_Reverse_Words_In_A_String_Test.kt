package com.llollox.algorithms.medium

import com.llollox.algorithms.problems.medium.N151_Reverse_Words_In_A_String
import junit.framework.Assert.assertEquals
import org.junit.Test

class N151_Reverse_Words_In_A_String_Test {

    @Test
    fun test1() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "the sky is blue"
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternMatching(input)
        assertEquals("blue is sky the", output)
    }

    @Test
    fun test2() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "  hello world!  "
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternMatching(input)
        assertEquals("world! hello", output)
    }

    @Test
    fun test3() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "a good   example"
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternMatching(input)
        assertEquals("example good a", output)
    }

    @Test
    fun test4() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "the sky is blue"
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternPointers(input)
        assertEquals("blue is sky the", output)
    }

    @Test
    fun test5() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "  hello world!  "
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternPointers(input)
        assertEquals("world! hello", output)
    }

    @Test
    fun test6() {
        val N151_Reverse_Words_In_A_String = N151_Reverse_Words_In_A_String()
        val input = "a good   example"
        val output = N151_Reverse_Words_In_A_String.reverseWordsPatternPointers(input)
        assertEquals("example good a", output)
    }
}