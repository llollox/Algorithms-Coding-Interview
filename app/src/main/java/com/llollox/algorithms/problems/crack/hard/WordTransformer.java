package com.llollox.algorithms.problems.crack.hard;

import java.util.*;

public class WordTransformer {

    /*
        Given two words of equal length that are in a dictionary,
        write a method to transform one word into the other word
        by changing only one letter at a time.

        The new word you get in each step must be in the dictionary.

        EXAMPLE
        Input: DAMP, LIKE
        Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
     */

    /*

        APPROACH Time O(N^2 * S + (N + M))
        - For each word in the set, take it as a graph and connect two words
        only if they differ at most of a character
        - Is there a path between damp and like nodes? DFS. O(N + M)

        How to build a graph. O(N^2 * S)
            - Scorro tutte le parole nell’array e creo i nodi O(N)
                - Per ogni parola nell’array scorro tutte le altre parole nell’array: O(N^2)
                - Se differiscono per un carattere allora creo un arco che le collega O(S)

        How to know if two strings differ by at most one char O(S), where S is the longest string
            - Basta scorrerle con lo stesso indice
            - quando trovo una differenza setto un flag
            - se ne trovo un’altra return false
            - se riesco ad arrivare alla fine return true
     */

    public List<String> wordTransformerDFS(String start, String end, String[] strings) {
        HashMap<String, List<String>> graph = this.buildGraph(strings);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        ArrayList<String> result = new ArrayList<>();
        result.add(start);

        if (dfs(graph, start, end, visited, result)) {
            return result;
        }
        else {
            return null;
        }
    }

    private HashMap<String, List<String>> buildGraph(String[] strings) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String string : strings) {
            graph.put(string, getAdj(string, strings));
        }

        return graph;
    }


    private boolean dfs(
            HashMap<String, List<String>> graph,
            String string,
            String goal,
            Set<String> visited,
            ArrayList<String> result) {

        if (string.equals(goal)) {
            return true;
        }

        for (String adj : graph.get(string)) {
            if (!visited.contains(adj)) {
                visited.add(adj);
                result.add(adj);
                boolean dfsResult = dfs(graph, adj, goal, visited, result);
                if (dfsResult) {
                    return true;
                }
            }
        }

        result.remove(string);
        return false;
    }


    private List<String> getAdj(String s, String[] strings) {
        ArrayList<String> result = new ArrayList<>();
        for (String string : strings) {
            if (!s.equals(string) && differByAtMostOneCharacter(s, string)) {
                result.add(string);
            }
        }
        return result;
    }

    private boolean differByAtMostOneCharacter(String a, String b) {
        if (a == null || b == null || b.length() != a.length()) {
            return false;
        }

        int i = 0;
        boolean differFound = false;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                if (differFound) {
                    return false;
                }
                else {
                    differFound = true;
                }
            }

            i += 1;
        }

        return true;
    }

    // BFS *************************************************************************************************************
    public List<String> wordTransformerBFS(String start, String end, String[] strings) {
        return bfs(start, end, this.buildGraph(strings));
    }

    private ArrayList<String> bfs(String start, String end, HashMap<String, List<String>> graph) {
        final HashMap<String, Integer> distance = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        HashMap<String, String> parent = new HashMap<>();

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(distance.get(s1), distance.get(s2));
            }
        });

        for (String key : graph.keySet()) {
            distance.put(key, Integer.MAX_VALUE);
            parent.put(key, null);
        }

        distance.put(start, 0);
        queue.add(start);
        visited.add(start);


        while (!queue.isEmpty()) {
            String peek = queue.poll();
            for (String adj : graph.get(peek)) {

                int newDistance = distance.get(peek) + 1;
                if (newDistance < distance.get(adj)) {
                    distance.put(adj, newDistance);
                    parent.put(adj, peek);
                }

                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }

        if (distance.get(end) == Integer.MAX_VALUE) {
            return null;
        }
        else {
            return getPath(parent, end);
        }
    }

    private ArrayList<String> getPath(HashMap<String, String> parent, String end) {
        return getPath(parent, end, new ArrayList<String>());
    }

    private ArrayList<String> getPath(HashMap<String, String> parent, String current, ArrayList<String> result) {

        if (parent.get(current) != null) {
            getPath(parent, parent.get(current), result);
        }

        result.add(current);

        return result;
    }

    public LinkedList<String> transform(String start, String end, String[] words) {
        HashMap<String, List<String>> graph = this.buildGraph(words);
        BFSData sourceData = new BFSData(start);
        BFSData destData = new BFSData(end);

        while (!sourceData.isFinished() && !destData.isFinished()) {

            String collision = searchLevel(graph, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }

            collision = searchLevel(graph, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision);
            }
        }

        return null;
    }


    String searchLevel(HashMap<String, List<String>> graph, BFSData primary, BFSData secondary) {
        /* We only want to search one level at a time. Count how many nodes are
         * currently in the primary's level and only do that many nodes. We'll continue
         * to add nodes to the end. */

        int count = primary.toVisit.size();
        for (int i=0; i<count; i++) {

            // Pull out the first node
            PathNode pathNode = primary.toVisit.poll();
            String word = pathNode.getWord();

            // Check if it's already been visited
            if (secondary.visited.containsKey(word)) {
                return pathNode.getWord();
            }

            // Add friends to queue
            for (String w : graph.get(word)) {
                if (!primary.visited.containsKey(w)) {
                    PathNode next = new PathNode(w, pathNode);
                    primary.visited.put(w, next);
                    primary.toVisit.add(next);
                }
            }
        }

        return null;
    }

    LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);
        LinkedList<String> pathOne = end1.collapse(false); // forward
        LinkedList<String> pathTwo = end2.collapse(true); // reverse
        pathTwo.removeFirst(); // Remove connection node
        pathOne.addAll(pathTwo); // Add second path
        return pathOne;
    }

    private static class BFSData {
        public Queue<PathNode> toVisit = new LinkedList<>();
        public HashMap<String, PathNode> visited = new HashMap<>();

        public BFSData(String root) {
            PathNode sourcePath = new PathNode(root, null);
            this.toVisit.add(sourcePath);
            this.visited.put(root, sourcePath);
        }

        public boolean isFinished() {
            return toVisit.isEmpty();
        }
    }

    private static class PathNode {

        private String word;
        private PathNode previousNode;

        public PathNode(String word, PathNode previous) {
            this.word = word;
            this.previousNode = previous;
        }

        public String getWord() {
            return word;
        }

        public LinkedList<String> collapse(boolean startsWithRoot) {
            LinkedList<String> path = new LinkedList<>();
            PathNode node = this;
            while (node != null) {
                if (startsWithRoot) {
                    path.addLast(node.word);
                }
                else {
                    path.addFirst(node.word);
                }
                node = node.previousNode;
            }

            return path;
        }
    }
}
