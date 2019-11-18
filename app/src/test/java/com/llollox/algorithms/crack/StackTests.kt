package com.llollox.algorithms.crack

import com.llollox.algorithms.problems.crack.stacks.SortStack
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*

class StackTests {

    @Test
    fun sortStack() {
        val sortString = SortStack()
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(6)
        stack.push(78)
        stack.push(12)
        stack.push(3)

        sortString.sort(stack)

        assertEquals(1, stack.pop())
        assertEquals(3, stack.pop())
        assertEquals(6, stack.pop())
        assertEquals(12, stack.pop())
        assertEquals(78, stack.pop())
    }
}