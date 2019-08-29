package previmedical.it.leetcode.problems.crack.hard;

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

    public List<String> wordTransformer(String start, String end, String[] strings) {
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


}
