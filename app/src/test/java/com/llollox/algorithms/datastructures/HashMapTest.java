package com.llollox.algorithms.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class HashMapTest {


    public HashMap<Integer, List<Integer>> buildGraph(int[][] matrix) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        if (matrix == null || matrix.length == 0) {
            return graph;
        }

        for (int[] array: matrix) {
            for (int i=0; i<array.length - 1; i++) {
                int node = array[i];
                int adj = array[i+1];
                List<Integer> adjs = graph.get(node);

                if (adjs == null) {
                    adjs = new ArrayList<>();
                    adjs.add(adj);
                    graph.put(node, adjs);
                }
                else {
                    adjs.add(adj);
                }
            }
        }

        return graph;
    }

    public List<Integer> topologicalSort(int[][] matrix) {
        ArrayList<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return results;
        }

        HashMap<Integer, List<Integer>> graph = buildGraph(matrix);

        if (hasCycle(graph)) {
            return results;
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> toVisit = new HashSet<>(graph.keySet());

        while (!toVisit.isEmpty()) {
            Integer node = toVisit.iterator().next();
            topDfs(graph, node, stack, visited);
            toVisit.removeAll(visited);
            visited.clear();
        }

        while (!stack.isEmpty()) {
            results.add(stack.pop());
        }

        return results;
    }

    private boolean hasCycle(HashMap<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> toVisit = new HashSet<>(graph.keySet());

        while (!toVisit.isEmpty()) {
            Integer node = toVisit.iterator().next();
            if (hasCycleDfs(graph, node, visited)) {
                return true;
            }
            toVisit.removeAll(visited);
            visited.clear();
        }

        return false;
    }

    private boolean hasCycleDfs(HashMap<Integer, List<Integer>> graph, Integer node,
                                HashSet<Integer> visited) {
        visited.add(node);

        List<Integer> adjs = graph.get(node);
        if (adjs != null && !adjs.isEmpty()) {
            for (Integer adj : adjs) {
                if (visited.contains(adj)) {
                    return true;
                }
                else {
                    if (hasCycleDfs(graph, adj, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void topDfs(
            HashMap<Integer, List<Integer>> graph, Integer node,
            Stack<Integer> stack,  HashSet<Integer> visited) {

        visited.add(node);
        List<Integer> adjs = graph.get(node);
        if (adjs != null && !adjs.isEmpty()) {
            for (Integer adj : adjs) {
                if (!visited.contains(adj)) {
                    topDfs(graph, adj, stack, visited);
                }
            }
        }
        stack.push(node);
    }

    @Test
    public void topSortTest() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[] {1, 3, 5};
        matrix[1] = new int[] {1, 5, 9};
        matrix[2] = new int[] {3, 7, 5};

        List<Integer> output = topologicalSort(matrix);
        int value = output.get(0);
        Assert.assertEquals(1, value);
    }

    @Test
    public void topSortWithCycleTest() {
        int[][] matrix = new int[4][];
        matrix[0] = new int[] {1, 3, 5};
        matrix[1] = new int[] {1, 5, 9};
        matrix[2] = new int[] {3, 7, 5};
        matrix[3] = new int[] {9, 1};

        List<Integer> output = topologicalSort(matrix);
        Assert.assertEquals(0, output.size());
    }

    @Test
    public void hasSameInstance() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        Set<Integer> keys1 = map.keySet();
        Set<Integer> keys2 = map.keySet();
        Assert.assertEquals(keys1, keys2);
    }
}
