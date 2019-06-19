package previmedical.it.leetcode.crack

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.models.GraphNode
import previmedical.it.leetcode.models.TreeNode
import previmedical.it.leetcode.problems.crack.treegraph.ListOfDepths
import previmedical.it.leetcode.problems.crack.treegraph.MinimalTree
import previmedical.it.leetcode.problems.crack.treegraph.RouteBetweenNodes

class TreeGraphTests {

    @Test
    fun routeBetweenTwoNodesTest() {

        val node5 = GraphNode(5, listOf())
        val node3 = GraphNode(3, listOf())
        val node4 = GraphNode(4, listOf(node3, node5))
        val node2 = GraphNode(2, listOf(node4))
        val node1 = GraphNode(1, listOf(node2, node3))
        node5.adj = listOf(node1)

        val routeBetweenNodes = RouteBetweenNodes()

        Assert.assertEquals(true, routeBetweenNodes.searchPath(node1, node5))
        Assert.assertEquals(false, routeBetweenNodes.searchPath(node1, GraphNode(6, listOf())))
    }



    /*
        0  1  2  3  4  5  6  7  8  9

                         4
            1                        7
        0       2               5          8

                  3                6          9

     */


    @Test
    fun minimalTree() {
        val array = intArrayOf(0,1,2,3,4,5,6,7,8,9)
        val tree = MinimalTree().minimalTree(array)

        Assert.assertEquals(4, tree.`val`)

        // 4
        val left = tree.left
        val right = tree.right
        Assert.assertEquals(1, left.`val`)
        Assert.assertEquals(7, right.`val`)

        // 1
        Assert.assertEquals(0, left.left.`val`)
        Assert.assertEquals(2, left.right.`val`)

        // 7
        Assert.assertEquals(5, right.left.`val`)
        Assert.assertEquals(8, right.right.`val`)

        // 2
        Assert.assertEquals(3, left.right.right.`val`)

        // 8
        Assert.assertEquals(9, right.right.right.`val`)
    }


    @Test
    fun listOfDepthsTest() {

        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.right.left = TreeNode(6)
        root.right.right = TreeNode(7)

        val output = ListOfDepths().listOfDepths(root)

        Assert.assertEquals(1, output[0].size)
        Assert.assertEquals(1, output[0][0].`val`)

        Assert.assertEquals(2, output[1].size)
        Assert.assertEquals(2, output[1][0].`val`)
        Assert.assertEquals(3, output[1][1].`val`)

        Assert.assertEquals(4, output[2].size)
        Assert.assertEquals(4, output[2][0].`val`)
        Assert.assertEquals(5, output[2][1].`val`)
        Assert.assertEquals(6, output[2][2].`val`)
        Assert.assertEquals(7, output[2][3].`val`)
    }
}