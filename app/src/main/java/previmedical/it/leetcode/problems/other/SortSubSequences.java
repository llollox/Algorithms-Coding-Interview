package previmedical.it.leetcode.problems.other;

import previmedical.it.leetcode.models.ListNode;

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



    public static class TreeNode {
        public int value;
        public Set<TreeNode> children;

        public TreeNode(int value) {
            this.value = value;
            this.children = new HashSet<>();
        }

        public TreeNode(int value, Set<TreeNode> children) {
            this.value = value;
            this.children = children;
        }
    }

    public List<Integer> sortSubSequences(List<int[]> subsequences) {
        HashMap<Integer, TreeNode> map = this.buildGraph(subsequences);
        if (hasCycle(map)) {
            return null;
        }
        else {
            return topSort(map);
        }
    }


    /*

        Una dfs con uno stack in cui vado ad inserire:
            - PRIMA: i nodi adiacenti prima
            - POI: il nodo stesso. Post Ordine

        Una volta riempito lo stack, lo ribalto ed ottengo la lista ordinata.

     */

    private List<Integer> topSort(HashMap<Integer, TreeNode> map) {
        List<TreeNode> toBeVisited = new ArrayList<>(map.values());
        Stack<TreeNode> stack = new Stack<>();

        while (!toBeVisited.isEmpty()) {
            TreeNode first = toBeVisited.get(0);
            this.topSortDfs(first, stack, toBeVisited);
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sortedList.add(node.value);
        }

        return sortedList;
    }

    private void topSortDfs(TreeNode node, Stack<TreeNode> stack, List<TreeNode> toBeVisited) {

        if (node.children != null && !node.children.isEmpty()) {
            for (TreeNode adj : node.children) {
                if (toBeVisited.contains(adj)) {
                    topSortDfs(adj, stack, toBeVisited);
                }
            }
        }

        toBeVisited.remove(node);
        stack.push(node);
    }

    private boolean hasCycle(HashMap<Integer, TreeNode> map) {

        // Insert all nodes into a set
        Set<TreeNode> visited = new HashSet<>();

        while (visited.size() < map.size()) {
            TreeNode node = getFirstUnvisitedNode(map, visited);
            HashSet<TreeNode> set = new HashSet<>();
            if (dfs(node, visited, set)) {
                return true;
            }
        }
        return false;
    }

    private TreeNode getFirstUnvisitedNode(HashMap<Integer, TreeNode> map, Set<TreeNode> visited) {
        for (TreeNode node : map.values()) {
            if (!visited.contains(node)) {
                return node;
            }
        }

        throw new RuntimeException("Node not found");
    }

    private boolean dfs(TreeNode node, Set<TreeNode> visited, Set<TreeNode> recursionVisitedNodes) {
        visited.add(node);

        recursionVisitedNodes.add(node);

        for (TreeNode adj: node.children) {
            if (recursionVisitedNodes.contains(adj)) {
                return true;
            }
            else {
                if (dfs(adj, visited, recursionVisitedNodes)) {
                    return true;
                }
            }
        }

        recursionVisitedNodes.remove(node);

        return false;
    }

    private HashMap<Integer, TreeNode> buildGraph(List<int[]> subsequences) {

        HashMap<Integer, TreeNode> map = new HashMap<>();

        for (int[] array: subsequences) {

            for (int i=0; i< array.length; i++) {

                int value = array[i];

                TreeNode valueNode = map.get(value);
                if (valueNode == null) {
                    valueNode = new TreeNode(value);
                    map.put(value, valueNode);
                }

                if (i < array.length - 1) {

                    int nextValue = array[i+1];

                    TreeNode nextValueNode = map.get(nextValue);

                    if (nextValueNode == null) { // Value not found
                        nextValueNode = new TreeNode(nextValue);
                        map.put(nextValue, nextValueNode);
                    }

                    if (valueNode.children == null) {
                        valueNode.children = new HashSet<>();
                    }

                    valueNode.children.add(nextValueNode);
                }
            }
        }

        return map;
    }




}
