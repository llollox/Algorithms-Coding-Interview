package previmedical.it.leetcode.problems.crack.treegraph;

import previmedical.it.leetcode.models.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteBetweenNodes {

    /*
        Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */

    public boolean searchPath(GraphNode start, GraphNode end) {

        if (start == null || end == null) {
            return false;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(start);

        Set<GraphNode> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            GraphNode top = queue.poll();
            if (top == end) {
                return true;
            }

            visited.add(top);

            for (GraphNode node : top.adj) {

                if (!visited.contains(node)) {
                    queue.add(node);
                }
            }
        }

        return false;
    }

}
