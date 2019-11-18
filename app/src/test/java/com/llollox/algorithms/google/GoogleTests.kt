package com.llollox.algorithms.google

import com.llollox.algorithms.problems.google.DeleteSubTree
import com.llollox.algorithms.problems.google.FindMaximumSubString
import junit.framework.Assert.assertEquals
import org.junit.Test

class GoogleTests {


    /*

        4
     2     6
   1   3  5  7

     */

    @Test
    fun deleteSubTreeTests() {

        val n1 = DeleteSubTree.TreeNode(1, 1)
        val n2 = DeleteSubTree.TreeNode(0, 2)
        val n3 = DeleteSubTree.TreeNode(1, 3)
        val n4 = DeleteSubTree.TreeNode(-1, 4)
        val n5 = DeleteSubTree.TreeNode(2, 5)
        val n6 = DeleteSubTree.TreeNode(0, 6)
        val n7 = DeleteSubTree.TreeNode(2, 7)

        val tree = DeleteSubTree.Tree()
        tree.nodes = arrayListOf(n4, n2, n6, n1, n3, n5, n7)

        val deleteSubTree = DeleteSubTree()
        deleteSubTree.deleteSubTree(tree, 2)

        assertEquals(4, tree.nodes.size)
        assertEquals(4, tree.nodes[0].value)
        assertEquals(2, tree.nodes[1].value)
        assertEquals(1, tree.nodes[2].value)
        assertEquals(3, tree.nodes[3].value)
    }

    @Test
    fun findMaximumSubStringTest() {
        val findMaximumSubString = FindMaximumSubString()

        val s = "aabbcccd"
        assertEquals(5, findMaximumSubString.getMaxSubstringLength(s, 2))
        assertEquals(7, findMaximumSubString.getMaxSubstringLength(s, 3))
        assertEquals(8, findMaximumSubString.getMaxSubstringLength(s, 4))
    }

    @Test
    fun findMaximumSubStringTest2() {
        val findMaximumSubString = FindMaximumSubString()

        val s = "aabbcccddddg"
        assertEquals(7, findMaximumSubString.getMaxSubstringLength(s, 2))
        assertEquals(9, findMaximumSubString.getMaxSubstringLength(s, 3))
        assertEquals(11, findMaximumSubString.getMaxSubstringLength(s, 4))
    }
}