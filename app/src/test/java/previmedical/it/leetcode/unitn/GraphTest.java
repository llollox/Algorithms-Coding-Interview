package previmedical.it.leetcode.unitn;

import org.junit.Assert;
import org.junit.Test;
import previmedical.it.leetcode.problems.unitn.graph.DetectCycle;
import previmedical.it.leetcode.problems.unitn.graph.KruskalMinimumSpanningTree;

public class GraphTest {

    // Undirected Graph *************************************************************************
    @Test
    public void hasCycleUndirectedGraphFalseTest() {
        DetectCycle detectCycle = new DetectCycle();
        DetectCycle.Graph graph = new DetectCycle.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);

        Assert.assertFalse(detectCycle.hasCycleUndirected(graph));
    }

    @Test
    public void hasCycleUndirectedGraphTrueTest() {
        DetectCycle detectCycle = new DetectCycle();
        DetectCycle.Graph graph = new DetectCycle.Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);

        Assert.assertTrue(detectCycle.hasCycleUndirected(graph));
    }

    @Test
    public void hasCycle2ComponentsUndirectedGraphTrueTest() {
        DetectCycle detectCycle = new DetectCycle();
        DetectCycle.Graph graph = new DetectCycle.Graph(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);

        Assert.assertTrue(detectCycle.hasCycleUndirected(graph));
    }


    // Directed Graph ******************************************************
    @Test
    public void hasCycleDirectedGraphTrueTest() {
        DetectCycle detectCycle = new DetectCycle();
        DetectCycle.Graph graph = new DetectCycle.Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        Assert.assertTrue(detectCycle.hasCycleDirected(graph));
    }

    @Test
    public void hasCycleDirectedGraphFalseTest() {
        DetectCycle detectCycle = new DetectCycle();
        DetectCycle.Graph graph = new DetectCycle.Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        Assert.assertFalse(detectCycle.hasCycleDirected(graph));
    }

    @Test
    public void kruskalMinimumSpanningTreeTest() {
        KruskalMinimumSpanningTree.Graph g = new KruskalMinimumSpanningTree.Graph();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);

        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 4, 7);
        g.addEdge(1, 3, 4);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 3, 1);
        g.addEdge(4, 5, 3);

        KruskalMinimumSpanningTree mst = new KruskalMinimumSpanningTree();
        int output = mst.minimumSpanningTree(g);

        Assert.assertEquals(7, output);
    }


}
