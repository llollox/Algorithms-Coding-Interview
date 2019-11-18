package com.llollox.algorithms.crack

import com.llollox.algorithms.models.ListNode
import com.llollox.algorithms.problems.crack.linkedList.Intersection
import com.llollox.algorithms.problems.crack.linkedList.PalindromeLinkedList
import com.llollox.algorithms.problems.crack.linkedList.SumLists
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.Test

class LinkedListTests {

    @Test
    fun isPalindromeTests() {

        val palindromeHead = ListNode(1)
        palindromeHead.next = ListNode(2)
        palindromeHead.next.next = ListNode(3)
        palindromeHead.next.next.next = ListNode(4)
        palindromeHead.next.next.next.next = ListNode(3)
        palindromeHead.next.next.next.next.next = ListNode(2)
        palindromeHead.next.next.next.next.next.next = ListNode(1)

        val notPalindromeHead = ListNode(1)
        notPalindromeHead.next = ListNode(2)
        notPalindromeHead.next.next = ListNode(3)
        notPalindromeHead.next.next.next = ListNode(4)
        notPalindromeHead.next.next.next.next = ListNode(3)
        notPalindromeHead.next.next.next.next.next = ListNode(5)
        notPalindromeHead.next.next.next.next.next.next = ListNode(1)

        val isPalindrome = PalindromeLinkedList()

        Assert.assertEquals(true, isPalindrome.isPalindrome(palindromeHead))
        Assert.assertEquals(false, isPalindrome.isPalindrome(notPalindromeHead))

        Assert.assertEquals(true, isPalindrome.isPalindromeRecurse(palindromeHead))
        Assert.assertEquals(false, isPalindrome.isPalindromeRecurse(notPalindromeHead))
    }

    @Test
    fun intersection() {

        val head = ListNode(1)
        head.next = ListNode(2)
        head.next.next = ListNode(3)
        head.next.next.next = ListNode(4)
        head.next.next.next.next = ListNode(3)
        head.next.next.next.next.next = ListNode(2)
        head.next.next.next.next.next.next = ListNode(1)

        val head2intersect = ListNode(5)
        head2intersect.next = ListNode(6)
        head2intersect.next.next = ListNode(7)
        head2intersect.next.next.next = head.next.next.next

        val head2NonIntersect = ListNode(5)
        head2NonIntersect.next = ListNode(6)
        head2NonIntersect.next.next = ListNode(7)

        val intersection = Intersection()

        Assert.assertEquals(head.next.next.next, intersection.intersection(head, head2intersect))
        Assert.assertEquals(null, intersection.intersection(head, head2NonIntersect))

    }


    @Test
    fun sumOfListsInCorrectOrderTest() {
        val sumLists = SumLists()

        val l1 = ListNode(1)
        l1.next = ListNode(2)
        l1.next.next = ListNode(3)

        val l2 = ListNode(4)
        l2.next = ListNode(7)

        val sum = sumLists.calculateSumCorrectOrder(l1, l2)
        assertEquals(1, sum.`val`)
        assertEquals(7, sum.next.`val`)
        assertEquals(0, sum.next.next.`val`)
    }
}