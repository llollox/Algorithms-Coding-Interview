package previmedical.it.leetcode.problems.unitn.graph;

import previmedical.it.leetcode.models.Graph;
import previmedical.it.leetcode.models.GraphNode;

import java.util.*;

/*
    Time: O(|V| * log(|V|) + |E|)
    Space: O(|V|)
 */
public class Dijkstra {

    public static class Result {
        int distance;
        GraphNode previous;

        public Result(int distance, GraphNode previous) {
            this.distance = distance;
            this.previous = previous;
        }
    }

    public HashMap<GraphNode, Result> dijkstra(GraphNode node, final Graph graph) {

        final HashMap<GraphNode, Result> map = new HashMap<>();

        for (GraphNode graphNode : graph.nodes) {
            int distance = graphNode == node ? 0 : Integer.MAX_VALUE;
            map.put(graphNode, new Result(distance, null));
        }

        PriorityQueue<GraphNode> queue = new PriorityQueue<>(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode n1, GraphNode n2) {
                return Integer.compare(map.get(n1).distance, map.get(n2).distance);
            }
        });

        Set<GraphNode> visited = new HashSet<>();

        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode peek = queue.poll();

            for (GraphNode adj : graph.adj(peek)) {

                int distance = graph.weight(peek, adj) + map.get(peek).distance;
                if (distance < map.get(adj).distance) {
                    map.get(adj).distance = distance;
                    map.get(adj).previous = peek;
                }

                if (!visited.contains(adj)) {
                    queue.add(adj);
                    visited.add(adj);
                }
            }
        }

        return map;
    }
}
