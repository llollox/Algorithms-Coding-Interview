package com.llollox.algorithms.problems.topics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    public static class Node {
        int val;
        LinkedList<Node> adj;

        public Node(int val, LinkedList<Node> adj) {
            this.val = val;
            this.adj = adj;
        }
    }


    public String bfs(Node n) {

        StringBuilder sb = new StringBuilder();

        LinkedList<Node> queue = new LinkedList();
        HashSet<Node> visited = new HashSet<>();

        queue.add(n);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            Iterator<Graph.Node> iterator = current.adj.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (!visited.contains(node)) {
                    queue.add(node);
                }
            }

            // Visit Node
            sb.append(current.val);

            // Mark node as visited
            visited.add(current);
        }

        return sb.toString();
    }

    public String dfsRecursive(Node current, HashSet<Graph.Node> visited, StringBuilder sb) {

        // Visit node
        sb.append(current.val);

        // Mark visited
        visited.add(current);


        Iterator<Graph.Node> iterator = current.adj.iterator();
        while (iterator.hasNext()) {

            Node node = iterator.next();

            if (!visited.contains(node)) {
                dfsRecursive(node, visited, sb);
            }
        }

        return sb.toString();
    }

    public String dfsIterative(Node node) {
        StringBuilder sb = new StringBuilder();
        HashSet<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);


        while (!stack.isEmpty()) {

            Node current = stack.pop();

            if (!visited.contains(current)) {

                // Visit node
                sb.append(current.val);

                // Mark as visited
                visited.add(current);

                Iterator<Node> iterator = current.adj.iterator();

                while (iterator.hasNext()) {
                    Node n = iterator.next();
                    stack.push(n);
                }
            }
        }

        return sb.toString();
    }

}
