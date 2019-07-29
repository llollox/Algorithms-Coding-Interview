package previmedical.it.leetcode.problems.unitn;

import previmedical.it.leetcode.models.Graph;
import previmedical.it.leetcode.models.GraphNode;

import java.util.*;

public class TopologicalSort {

    public List<GraphNode> topologicalSort(Graph graph) {
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode node : graph.nodes) {
            if (!visited.contains(node)) {
                dfs(node, stack, visited);
            }
        }

        ArrayList<GraphNode> nodes = new ArrayList<>();

        while (!stack.isEmpty()) {
            nodes.add(stack.pop());
        }

        return nodes;
    }

    private void dfs(GraphNode node, Stack<GraphNode> stack, Set<GraphNode> visited) {
        visited.add(node);

        for (GraphNode adjNode: node.adj) {
            if (!visited.contains(adjNode)) {
                dfs(adjNode, stack, visited);
            }
        }

        stack.push(node);
    }

}
