package previmedical.it.leetcode.unitn

import junit.framework.Assert
import org.junit.Test
import previmedical.it.leetcode.models.Graph
import previmedical.it.leetcode.models.GraphNode
import previmedical.it.leetcode.problems.unitn.KnightDialer
import previmedical.it.leetcode.problems.unitn.graph.TopologicalSort
import previmedical.it.leetcode.problems.unitn.dynamic.LongestCommonSubsequence
import previmedical.it.leetcode.problems.unitn.graph.Dijkstra


class UnitnTest  {

    @Test
    fun knightDialer() {

        val knightDialer = KnightDialer()

//        Assert.assertEquals(1, knightDialer.knightDialer(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialer(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialer(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialer(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialer(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialer(1, 50))
//
//        Assert.assertEquals(1, knightDialer.knightDialerRecursive(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialerRecursive(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialerRecursive(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialerRecursive(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialerRecursive(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialerRecursive(1, 50))
//
//        Assert.assertEquals(1, knightDialer.knightDialerDp(1, 0))
//        Assert.assertEquals(2, knightDialer.knightDialerDp(1, 1))
//        Assert.assertEquals(5, knightDialer.knightDialerDp(1, 2))
//        Assert.assertEquals(10, knightDialer.knightDialerDp(1, 3))
//        Assert.assertEquals(26, knightDialer.knightDialerDp(1, 4))
//        Assert.assertEquals(1694498816, knightDialer.knightDialerDp(1, 50))

//
        System.out.println(System.currentTimeMillis())
        Assert.assertEquals(1912111104, knightDialer.knightDialerRecursive(1, 30))
        System.out.println(System.currentTimeMillis())

        System.out.println("------------------------------------")

        System.out.println(System.currentTimeMillis())
        Assert.assertEquals(1912111104, knightDialer.knightDialerDp(1, 30))
        System.out.println(System.currentTimeMillis())
    }

    @Test
    fun lcsTest() {

        val inputA = "AAAATTGA"
        val inputB = "TAACGATA"

        val lcs = LongestCommonSubsequence()
        val output = lcs.lcs(inputA, inputB)

        Assert.assertEquals("AAATA", output)
    }

    @Test
    fun topologicalSortTest() {

        val node0 = GraphNode(0, listOf())
        val node1 = GraphNode(1, listOf())
        val node3 = GraphNode(3, listOf(node1))
        val node2 = GraphNode(2, listOf(node3))
        val node4 = GraphNode(4, listOf(node0, node1))
        val node5 = GraphNode(5, listOf(node2, node0))

        val nodes = listOf(node0, node1, node2, node3, node4, node5)
        val graph = Graph(nodes)

        val topologicalSort = TopologicalSort()
        val output = topologicalSort.topologicalSort(graph)

        Assert.assertEquals(6, output.size)
        Assert.assertEquals(5, output[0])
        Assert.assertEquals(4, output[1])
        Assert.assertEquals(2, output[2])
        Assert.assertEquals(3, output[3])
        Assert.assertEquals(1, output[4])
        Assert.assertEquals(0, output[5])
    }

    @Test
    fun dijkstraTest() {
        val node2 = GraphNode(2, listOf())
        val node3 = GraphNode(3, listOf())
        val node4 = GraphNode(4, listOf())
        val node5 = GraphNode(5, listOf())
        val node6 = GraphNode(6, listOf())
        val node1 = GraphNode(1, listOf())

        val graph = Graph(listOf(node1, node2, node3, node4, node5, node6), arrayOf(
            intArrayOf(0, 7, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 14),
            intArrayOf(7, 0, 10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(9, 10, 0, 11, Integer.MAX_VALUE, 2),
            intArrayOf(Integer.MAX_VALUE, 15, 11, 0, 6, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0, 9),
            intArrayOf(14, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 9, 0)
        ))

        val dijkstra = Dijkstra()
        val output = dijkstra.dijkstra(node1, graph)

        Assert.assertEquals(6, output.size)
    }
    
    @Test
    fun adjTest() {
        val node2 = GraphNode(2, listOf())
        val node3 = GraphNode(3, listOf())
        val node4 = GraphNode(4, listOf())
        val node5 = GraphNode(5, listOf())
        val node6 = GraphNode(6, listOf())
        val node1 = GraphNode(1, listOf())

        val graph = Graph(listOf(node1, node2, node3, node4, node5, node6), arrayOf(
            intArrayOf(0, 7, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 14),
            intArrayOf(7, 0, 10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(9, 10, 0, 11, Integer.MAX_VALUE, 2),
            intArrayOf(Integer.MAX_VALUE, 15, 11, 0, 6, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0, 9),
            intArrayOf(14, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 9, 0)
        ))

        Assert.assertEquals(listOf(node2, node3, node6), graph.adj(node1))
        Assert.assertEquals(listOf(node1, node3, node4), graph.adj(node2))
        Assert.assertEquals(listOf(node1, node2, node4, node6), graph.adj(node3))
        Assert.assertEquals(listOf(node2, node3, node5), graph.adj(node4))
        Assert.assertEquals(listOf(node4, node6), graph.adj(node5))
        Assert.assertEquals(listOf(node1, node3, node5), graph.adj(node6))
    }

    @Test
    fun weightsTest() {
        val node2 = GraphNode(2, listOf())
        val node3 = GraphNode(3, listOf())
        val node4 = GraphNode(4, listOf())
        val node5 = GraphNode(5, listOf())
        val node6 = GraphNode(6, listOf())
        val node1 = GraphNode(1, listOf())

        val graph = Graph(listOf(node1, node2, node3, node4, node5, node6), arrayOf(
            intArrayOf(0, 7, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 14),
            intArrayOf(7, 0, 10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE),
            intArrayOf(9, 10, 0, 11, Integer.MAX_VALUE, 2),
            intArrayOf(Integer.MAX_VALUE, 15, 11, 0, 6, Integer.MAX_VALUE),
            intArrayOf(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0, 9),
            intArrayOf(14, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 9, 0)
        ))

        Assert.assertEquals(14, graph.weight(node1, node6))
        Assert.assertEquals(0, graph.weight(node1, node1))
        Assert.assertEquals(7, graph.weight(node1, node2))
        Assert.assertEquals(9, graph.weight(node1, node3))
        Assert.assertEquals(14, graph.weight(node6, node1))
        Assert.assertEquals(7, graph.weight(node2, node1))
        Assert.assertEquals(9, graph.weight(node3, node1))
    }

}
