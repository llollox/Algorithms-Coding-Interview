package com.llollox.algorithms.problems.crack.treegraph;

import android.util.Pair;

import java.util.*;

public class BuildOrder {
    /*
    You are given a list of projects and a list of dependencies
    (which is a list of pairs of projects, where the second project is dependent on the first project).
    All of a project's dependencies must be built before the project is.
    Find a build order that will allow the projects to be built.
    If there is no valid build order, return an error.

    EXAMPLE
    Input: projects: a, b, c, d, e, f dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    Output:f, e, a, b, d, c
     */

    public static class Dep {
        public char first;
        public char second;

        public Dep(char first, char second) {
            this.first = first;
            this.second = second;
        }
    }


    public List<Character> buildOrder(List<Character> projects, List<Dep> dependencies) {
        HashMap<Character, List<Character>> graph = this.buildGraph(projects, dependencies);

        if (hasCycle(graph)) {
            return null;
        }

        return topSort(graph);
    }


    private List<Character> topSort(HashMap<Character, List<Character>> graph) {
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        Character current = firstUnvisited(graph, visited);

        while (current != null) {
            topSortDfs(graph, current, visited, stack);
            current = firstUnvisited(graph, visited);
        }

        ArrayList<Character> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void topSortDfs(HashMap<Character, List<Character>> graph, Character current, HashSet<Character> visited, Stack<Character> stack) {
        visited.add(current);

        for (Character adj : graph.get(current)) {
            if (!visited.contains(adj)) {
                topSortDfs(graph, adj, visited, stack);
            }
        }

        stack.push(current);
    }


    private boolean hasCycle(HashMap<Character, List<Character>> graph) {
        HashSet<Character> visited = new HashSet<>();
        Character current = firstUnvisited(graph, visited);

        while (current != null) {
            HashSet<Character> visitedRecurse = new HashSet<>();
            if (hasCycleDfs(graph, current, visited, visitedRecurse)) {
                return true;
            }
            else {
                current = firstUnvisited(graph, visited);
            }
        }

        return false;
    }

    private boolean hasCycleDfs(HashMap<Character, List<Character>> graph, Character current, HashSet<Character> visited, HashSet<Character> visitedRec) {
        visited.add(current);
        visitedRec.add(current);

        for (Character adj : graph.get(current)) {
            if (visitedRec.contains(adj)) {
                return true;
            }

            if (hasCycleDfs(graph, adj, visited, visitedRec)) {
                return true;
            }
        }

        visitedRec.remove(current);
        return false;
    }

    private Character firstUnvisited(HashMap<Character, List<Character>> graph, HashSet<Character> visited) {
        for (HashMap.Entry<Character, List<Character>> entry : graph.entrySet()) {
            Character project = entry.getKey();
            if (!visited.contains(project)) {
                return project;
            }
        }

        return null;
    }

    private HashMap<Character, List<Character>> buildGraph(List<Character> projects, List<Dep> dependencies) {
        HashMap<Character, List<Character>> graph = new HashMap<>(projects.size());
        for (Character project : projects) {
            graph.put(project, new ArrayList<Character>());
        }

        for (Dep dependency: dependencies) {
            Character first = dependency.first;
            Character second = dependency.second;

            graph.get(first).add(second);
        }

        return graph;
    }

    ////////////////////////////////////////////////////////////////
    /*
        Input:
            projects: a, b, c, d, e, f
            dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
        Output:
            f, e, a, b, d, c
     */

    /**
     *
     * N projects M edges
     * - Creo il grafo: Mappa<Character, List<Character>>  T O(M)   S: O(M)
     * - Verifico che il grafo non abbia cicli: T O(N + M)      S: O(N)
     *      - Faccio una dfs nel grafo verificando di non ritornare in un nodo nello stack di ricorsione.
     * - Faccio una dfs in post ordine salvando i nodi in uno stack T O(N + M)      S: O(N)
     * - Ritorno gli elementi dello stack all'opposto T O(N) S: O(N)
     *
     * Overall complexity T: O(N + M) S: O(N + M)
     */


    private HashMap<Character, List<Character>> buildGraph(String[][] dependencies) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (int i=0; i<dependencies.length; i++) {
            String[] dependency = dependencies[i];
            Character main = dependency[0].charAt(0);
            Character dependant = dependency[1].charAt(0);
            addDependency(graph, main, dependant);
        }
        return graph;
    }

    private boolean hasLoop(HashMap<Character, List<Character>> graph) {
        HashSet<Character> visited = new HashSet<>();
        for (Character p : graph.keySet()) {
            HashSet<Character> recSet = new HashSet<>();

            if (!visited.contains(p) && hasLoopDfs(graph, p, visited, recSet)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasLoopDfs(
            HashMap<Character, List<Character>> graph,
            Character node,
            HashSet<Character> visited,
            HashSet<Character> recSet) {

        visited.add(node);
        recSet.add(node);

        for (Character project : getAdj(graph, node)) {

            if (recSet.contains(project)) {
                return true;
            }

            if (hasLoopDfs(graph, project, visited, recSet)) {
                return true;
            }
            recSet.remove(project);
        }

        return false;
    }

    public String[] order(String[] projects, String[][] dependencies) {
        HashMap<Character, List<Character>> graph = buildGraph(dependencies);
        if (hasLoop(graph)) {
            return new String[0];
        }

        Stack<Character> stack = new Stack<>();
        HashSet<Character> visited = new HashSet<>();

        for (String project : projects) {
            Character p = project.charAt(0);
            if (!visited.contains(p)) {
                topSortOrderDfs(graph, p, visited, stack);
            }
        }

        String[] ordered = new String[projects.length];
        for (int i=0; i<ordered.length; i++) {
            ordered[i] = "" + stack.pop();
        }

        return ordered;
    }

    private void topSortOrderDfs(
            HashMap<Character, List<Character>> graph,
            Character node,
            HashSet<Character> visited,
            Stack<Character> stack) {

        visited.add(node);

        for (Character adj : getAdj(graph, node)) {
            if (!visited.contains(adj)) {
                topSortOrderDfs(graph, adj, visited, stack);
            }
        }

        stack.add(node);
    }

    private void addDependency(
            HashMap<Character, List<Character>> graph,
            Character main,
            Character dependant) {

        List<Character> adj = graph.get(main);
        if (adj == null) {
            adj = new ArrayList<>();
        }

        adj.add(dependant);
        graph.put(main, adj);
    }

    private List<Character> getAdj(HashMap<Character, List<Character>> graph, Character node) {
        List<Character> adj = graph.get(node);
        if (adj == null) {
            return new ArrayList<>();
        }
        else {
            return adj;
        }
    }
}
