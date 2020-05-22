package com.llollox.algorithms.problems.topics.graph;

import java.util.*;

public class KruskalMinimumSpanningTree {

    // Graph *******************************************************************************************
    public static class Edge {
        int src;
        int dst;
        int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public static class Graph {
        HashMap<Integer, List<Edge>> edges = new HashMap<>();

        public void addNode(int node) {
            this.edges.put(node, new ArrayList<Edge>());
        }

        public void addEdge(int src, int dst, int weight) {
            Edge edge = new Edge(src, dst, weight);
            this.edges.get(src).add(edge);
        }
    }


    // Disjoint Set **************************************************************************************
    public static class Subset {
        int parent;
        int rank;
    }

    int find(HashMap<Integer, Subset> subsets, int i) {

        Subset subset = subsets.get(i);

        if (subset.parent != i) {
            subset.parent = find(subsets, subset.parent);
        }

        return subset.parent;
    }

    void union(HashMap<Integer, Subset> subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (xRoot != yRoot) {
            Subset xRootSubset = subsets.get(xRoot);
            Subset yRootSubset = subsets.get(yRoot);

            if (xRootSubset.rank < yRootSubset.rank) {
                yRootSubset.parent = xRoot;
            }
            else if (xRootSubset.rank > yRootSubset.rank) {
                xRootSubset.parent = yRoot;
            }
            else {
                yRootSubset.parent = xRoot;
                xRootSubset.rank += 1;
            }
        }
    }

    // m + n log n
    // Kruskal Algorithm *********************************************************************************
    public int minimumSpanningTree(Graph g) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.weight, e2.weight);
            }
        });

        // m log m
        for (List<Edge> edges : g.edges.values()) {
            queue.addAll(edges);
        }

        // n
        HashMap<Integer, Subset> subsets = new HashMap<>();
        for (int node : g.edges.keySet()) {
            Subset s = new Subset();
            s.rank = 0;
            s.parent = node;
            subsets.put(node, s);
        }

        int edgesTaken = 0;
        int sum = 0;

        // m
        while (edgesTaken < g.edges.size() - 1 && !queue.isEmpty()) {
            Edge edge = queue.poll();

            if (find(subsets, edge.src) != find(subsets, edge.dst)) {
                edgesTaken += 1;
                sum += edge.weight;
                union(subsets, edge.src, edge.dst);
            }
        }

        return sum;
    }
}
