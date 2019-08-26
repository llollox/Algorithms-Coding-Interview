package previmedical.it.leetcode.crack

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.models.GraphNode
import previmedical.it.leetcode.models.TreeNode
import previmedical.it.leetcode.problems.crack.treegraph.*

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


    @Test
    fun checkBalancedTest() {

        val balanced = TreeNode(1)
        balanced.left = TreeNode(2)
        balanced.right = TreeNode(3)
        balanced.left.left = TreeNode(4)
        balanced.left.right = TreeNode(5)
        balanced.right.left = TreeNode(6)
        balanced.right.right = TreeNode(7)


        val unbalanced = TreeNode(1)
        unbalanced.left = TreeNode(2)
        unbalanced.right = TreeNode(3)
        unbalanced.right.right = TreeNode(4)
        unbalanced.right.right.right = TreeNode(5)
        unbalanced.right.right.right.right = TreeNode(6)

        val checkBalanced = CheckBalanced()

        Assert.assertEquals(true, checkBalanced.checkBalanced(balanced))
        Assert.assertEquals(true, checkBalanced.checkBalancedImproved(balanced))

        Assert.assertEquals(false, checkBalanced.checkBalanced(unbalanced))
        Assert.assertEquals(false, checkBalanced.checkBalancedImproved(unbalanced))
    }

    @Test
    fun randomNodeTest() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)
        tree.left.left = TreeNode(4)
        tree.left.right = TreeNode(5)
        tree.right.left = TreeNode(6)
        tree.right.right = TreeNode(7)

        val randomNode = RandomNode()
        val frequencies = HashMap<Int, Int>()

        (0..7000).forEach {
            val rnd = randomNode.randomNode(tree)
            frequencies[rnd.`val`] = frequencies[rnd.`val`]?.let { it + 1 } ?: 1
        }

        // All node must have been chosen roughly 1000 times
        Assert.assertNotNull(frequencies)
    }


    /*
            SUM = 3

              1
         2         4
      8    4    -1   9
     */
    @Test
    fun pathsWithSumTest() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(4)
        tree.left.left = TreeNode(8)
        tree.left.right = TreeNode(4)
        tree.right.left = TreeNode(-1)
        tree.right.right = TreeNode(9)

        val pathsWithSum = PathsWithSum()
        Assert.assertEquals(2, pathsWithSum.pathsWithSum(tree, 3))
    }
}