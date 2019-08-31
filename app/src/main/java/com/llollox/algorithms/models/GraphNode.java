package com.llollox.algorithms.models;

import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> adj;

    public GraphNode(int val, List<GraphNode> adj) {
        this.val = val;
        this.adj = adj;
    }
}
