package previmedical.it.leetcode.models;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<GraphNode> nodes;

    public int[][] weights;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public Graph(List<GraphNode> nodes, int[][] weights) {
        this.nodes = nodes;
        this.weights = weights;
    }

    public int weight(GraphNode node1, GraphNode node2) {
        if (node1 == node2) {
            return 0;
        }
        if (this.weights == null) {
            return 1;
        }
        else {
            int index1 = this.nodes.indexOf(node1);
            int index2 = this.nodes.indexOf(node2);
            return this.weights[index1][index2];
        }
    }

    public List<GraphNode> adj(GraphNode node) {
        ArrayList<GraphNode> adjList = new ArrayList<>();
        int nodeIndex = this.nodes.indexOf(node);

        for (GraphNode adj: this.nodes) {
            if (node != adj) {

                int adjIndex = this.nodes.indexOf(adj);
                if (this.weights[nodeIndex][adjIndex] < Integer.MAX_VALUE) {
                    adjList.add(adj);
                }
            }
        }
        return adjList;
    }
}
