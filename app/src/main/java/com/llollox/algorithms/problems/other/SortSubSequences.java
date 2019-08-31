package com.llollox.algorithms.problems.other;

import java.util.*;

public class SortSubSequences {

    /*
        Given an array of subsequences of integers.
        Return the original subsequence.

        INPUT: [1, 9, 5][1, 3, 9]
        OUTPUT: [1,3,9,5]

        Solution.
        - Build a graph starting from the subsequences
        - Verify that the graph has no cycles
        - TopSort the graph
     */



//    public static class TreeNode {
//        public int value;
//        public Set<TreeNode> children;
//
//        public TreeNode(int value) {
//            this.value = value;
//            this.children = new HashSet<>();
//        }
//
//        public TreeNode(int value, Set<TreeNode> children) {
//            this.value = value;
//            this.children = children;
//        }
//    }

    public List<Integer> sortSubSequences(List<int[]> subsequences) {

        Graph g = this.buildGraph(subsequences);

        if (hasCycle(g)) {
            return null;
        }
        else {
            return topSort(g);
        }
    }


    /*

        Una dfs con uno stack in cui vado ad inserire:
            - PRIMA: i nodi adiacenti prima
            - POI: il nodo stesso. Post Ordine

        Una volta riempito lo stack, lo ribalto ed ottengo la lista ordinata.

     */

    private List<Integer> topSort(Graph g) {

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        Integer node = getFirstUnvisitedNode(g, visited);

        while (node != null) {
            topSortDfs(g, node, stack, visited);
            node = getFirstUnvisitedNode(g, visited);
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }

        return sortedList;
    }

    private void topSortDfs(Graph g, int node, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(node);

        for (int adj : g.adj.get(node)) {
            if (!visited.contains(adj)) {
                topSortDfs(g, adj, stack, visited);
            }
        }

        stack.add(node);
    }

    private boolean hasCycle(Graph g) {
        if (g == null || g.adj.size() < 2) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        Integer first = getFirstUnvisitedNode(g, visited);

        while (first != null) {

            HashSet<Integer> visitedRec = new HashSet<>();
            if (hasCycleDfs(g, first, visited, visitedRec)) {
                return true;
            }

            first = getFirstUnvisitedNode(g, visited);
        }

        return false;
    }

    private Integer getFirstUnvisitedNode(Graph g, Set<Integer> visited) {
        for (Integer key : g.adj.keySet()) {
            if (!visited.contains(key)) {
                return key;
            }
        }

        return null;
    }

    private boolean hasCycleDfs(Graph g, int node, Set<Integer> visited, Set<Integer> visitedRec) {
        visited.add(node);
        visitedRec.add(node);

        for (int adj : g.adj.get(node)) {
            if (visitedRec.contains(adj)) {
                return true;
            }
            else if (hasCycleDfs(g, adj, visited, visitedRec)) {
                return true;
            }
        }

        visitedRec.remove(node);
        return false;
    }

    private static class Graph {

        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        public boolean hasNode(int value) {
            return adj.get(value) != null;
        }

        public void addNode(int value) {
            adj.put(value, new ArrayList<Integer>());
        }

        public void addEdge(int src, int dst) {
            List<Integer> nodeAdj = adj.get(src);
            if (nodeAdj != null) {
                nodeAdj.add(dst);
            }
        }
    }

    private Graph buildGraph(List<int[]> subsequences) {

        Graph g = new Graph();

        for (int[] array: subsequences) {

            for (int i=0; i<array.length; i++) {
                int current = array[i];

                if (!g.hasNode(current)) {
                    g.addNode(current);
                }

                if (i < array.length - 1) {
                    int next = array[i + 1];
                    g.addEdge(current, next);
                }
            }
        }

        return g;
    }
}
