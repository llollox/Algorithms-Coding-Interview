package previmedical.it.leetcode.crack

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.models.ListNode
import previmedical.it.leetcode.problems.crack.linkedList.PalindromeLinkedList

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

}