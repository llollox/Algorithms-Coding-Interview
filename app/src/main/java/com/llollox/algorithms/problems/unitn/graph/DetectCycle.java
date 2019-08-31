package com.llollox.algorithms.problems.unitn.graph;

import java.util.*;

public class DetectCycle {

    public static class Graph {
        int V;
        List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();
            for (int i=0; i<V; i++) {
                this.adj.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int src, int dst) {
            this.adj.get(src).add(dst);
        }
    }


    // Directed Graph ********************************************************************
    public boolean hasCycleDirected(Graph g) {
        if (g == null || g.V < 2) {
            return false;
        }

        BitSet visited = new BitSet(g.V);
        BitSet recVisited = new BitSet(g.V);
        visited.clear();
        recVisited.clear();

        int node = 0;

        while (node != -1) {

            if (hasCycleDirectedDfs(g, node, visited, recVisited)) {
                return true;
            }

            node = getFirstUnvisited(visited, g.V);
        }

        return false;
    }

    private boolean hasCycleDirectedDfs(Graph g, int node, BitSet visited, BitSet recVisited) {
        visited.set(node, true);
        recVisited.set(node, true);

        for (int adj : g.adj.get(node)) {
            if (recVisited.get(adj)) {
                return true;
            }
            else if (hasCycleDirectedDfs(g, adj, visited, recVisited)) {
                return true;
            }
        }

        recVisited.set(node, false);

        return false;
    }

    // Undirected Graph ********************************************************************
    public boolean hasCycleUndirected(Graph g) {
        if (g == null || g.V < 2) {
            return false;
        }

        BitSet visited = new BitSet(100);
        visited.clear();

        int node = 0;

        while (node != -1) {
            if (hasCycleUndirectedDfs(g, node, -1, visited)) {
                return true;
            }

            node = getFirstUnvisited(visited, g.V);
        }

        return false;
    }

    private boolean hasCycleUndirectedDfs(Graph g, int node, int prev, BitSet visited) {
        visited.set(node, true);

        for (int adj : g.adj.get(node)) {
            if (adj != prev) {
                if (visited.get(adj)) {
                    return true;
                }
                else if (hasCycleUndirectedDfs(g, adj, node, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    // Util methods **************************************************************************
    private int getFirstUnvisited(BitSet visited, int n) {
        for (int i=0; i<n; i++) {
            if (!visited.get(i)) {
                return i;
            }
        }

        return -1;
    }
}
