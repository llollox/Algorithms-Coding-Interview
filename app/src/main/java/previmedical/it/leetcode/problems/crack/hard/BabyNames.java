package previmedical.it.leetcode.problems.crack.hard;

import kotlin.Pair;
import previmedical.it.leetcode.models.GraphNode;

import java.util.*;

public class BabyNames {

    /*
         Each year, the government releases a list of the 10,000 most common baby names and their frequencies
         (the number of babies with that name).
         The only problem with this is that some names have multiple spellings.
         For example, "John" and ''.Jon" are essentially the same name but would be listed separately in the list.

         Given two lists, one of names/frequencies and the other of pairs of equivalent names,
         write an algorithm to print a new list of the true frequency of each name.

         Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and Johnny are synonyms.
         (It is both transitive and symmetric.)
         In the final list, any name can be used as the "real" name.

         EXAMPLE
        Input:
        Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
        Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)

        Output: John (27), Kris (36)
     */

    public Map<String, Integer> babyNames(Map<String, Integer> nameFrequencies, List<Pair<String, String>> synonyms) {

        HashMap<String, Integer> babyNamesFrequencies = new HashMap<>();
        Map<String, Set<String>> synonymsMap = this.toMapOfSets(synonyms);

        for(HashMap.Entry<String, Integer> entry: nameFrequencies.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();

            String key = this.getKey(name, synonymsMap);

            Integer frequencyFound = babyNamesFrequencies.get(key);
            if (frequencyFound != null) {
                frequency = frequency + frequencyFound;
            }

            babyNamesFrequencies.put(key, frequency);
        }

        return babyNamesFrequencies;
    }


    private String getKey(String name, Map<String, Set<String>> synonyms) {
        for(Map.Entry<String, Set<String>> entry: synonyms.entrySet()) {
            Set<String> set = entry.getValue();
            if (set.contains(name)) {
                return entry.getKey();
            }
        }

        return name;
    }


    private Map<String, Set<String>> toMapOfSets(List<Pair<String, String>> pairs) {
        HashMap<String, Set<String>> map = new HashMap<>();

        for(Pair<String, String> pair : pairs) {

            Set<String> set = null;

            for(Set<String> s: map.values()) {
                if (s.contains(pair.getFirst()) || s.contains(pair.getSecond())) {
                    set = s;
                }
            }

            if (set == null) {
                set = new HashSet<>();
                map.put(pair.getFirst(), set);
            }

            set.add(pair.getFirst());
            set.add(pair.getSecond());
        }

        return map;
    }



    /*

        * Build a graph. For each name I create a node into the graph O(n)
        * For each synonym pair, I connect two edges O(m)
        * DFS into the graph and count each frequency (n + m)
        * Complexity   Time O(n)

     */

    public Map<String, Integer> babyNamesGraph(Map<String, Integer> nameFrequencies, List<Pair<String, String>> synonyms) {
        HashMap<String, NameGraphNode> graph = this.buildGraph(nameFrequencies.keySet());
        this.connectGraph(graph, synonyms);
        return calculateFrequencies(graph, nameFrequencies);
    }

    private Map<String, Integer> calculateFrequencies(HashMap<String, NameGraphNode> map, Map<String, Integer> nameFrequencies) {
        Set<NameGraphNode> visited = new HashSet<>();
        Map<String, Integer> frequencies = new HashMap<>();

        while (visited.size() < map.size()) {
            NameGraphNode first = getFirstUnvisitedNode(map, visited);
            int frequency = calculateFrequenciesDFS(first, visited, nameFrequencies);
            frequencies.put(first.name, frequency);
        }

        return frequencies;
    }

    private NameGraphNode getFirstUnvisitedNode(HashMap<String, NameGraphNode> map, Set<NameGraphNode> visited) {
        for (NameGraphNode node : map.values()) {
            if (!visited.contains(node)) {
                return node;
            }
        }

        return null;
    }

    private int calculateFrequenciesDFS(NameGraphNode node, Set<NameGraphNode> visited, Map<String, Integer> nameFrequencies) {
        visited.add(node);
        int frequencies = nameFrequencies.get(node.name) != null ? nameFrequencies.get(node.name) : 0;
        for (NameGraphNode child : node.children) {
            if (!visited.contains(child)) {
                frequencies += calculateFrequenciesDFS(child, visited, nameFrequencies);
            }
        }

        return frequencies;
    }

    private void connectGraph(HashMap<String, NameGraphNode> map, List<Pair<String, String>> synonyms) {
        for (Pair<String, String> synonym : synonyms) {

            NameGraphNode node1 = map.get(synonym.getFirst());
            if (node1 == null) {
                node1 = new NameGraphNode(synonym.getFirst());
                map.put(synonym.getFirst(), node1);
            }

            NameGraphNode node2 = map.get(synonym.getSecond());
            if (node2 == null) {
                node2 = new NameGraphNode(synonym.getSecond());
                map.put(synonym.getSecond(), node2);
            }

            node1.children.add(node2);
            node2.children.add(node1);
        }
    }

    private HashMap<String, NameGraphNode> buildGraph(Collection<String> names) {
        HashMap<String, NameGraphNode> map = new HashMap<>();

        for (String name : names) {
            map.put(name, new NameGraphNode(name));
        }

        return map;
    }

    private static class NameGraphNode {
        private String name;
        private List<NameGraphNode> children;

        NameGraphNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }
}
