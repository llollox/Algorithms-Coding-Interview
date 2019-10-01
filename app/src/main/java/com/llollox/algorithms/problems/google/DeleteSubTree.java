package com.llollox.algorithms.problems.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DeleteSubTree {

    public static class Tree {
        public List<TreeNode> nodes;
    }

    public static class TreeNode {

        public TreeNode(int parentIndex, int value) {
            this.parentIndex = parentIndex;
            this.value = value;
        }

        public int parentIndex;
        public int value;
    }


    public void deleteSubTree(Tree tree, int nodeIndex) {
        if (tree == null || tree.nodes == null || nodeIndex < 0 || nodeIndex >= tree.nodes.size()) {
            return;
        }

        HashMap<Integer, List<Integer>> childrenMap = this.buildChildrenMap(tree);
        ArrayList<Integer> indexesToRemove = new ArrayList<>();
        deleteSubTreeDfs(indexesToRemove, childrenMap, nodeIndex);

        Collections.sort(indexesToRemove);

        for (int i=indexesToRemove.size() -1; i>=0; i--) {
            int index = indexesToRemove.get(i);
            tree.nodes.remove(index);
        }
    }

    private void deleteSubTreeDfs(ArrayList<Integer> indexesToRemove, HashMap<Integer, List<Integer>> childrenMap, int indexNode) {
        indexesToRemove.add(indexNode);

        List<Integer> children = childrenMap.get(indexNode);
        if (children != null) {
            for (int childIndex : children) {
                deleteSubTreeDfs(indexesToRemove, childrenMap, childIndex);
            }
        }
    }

    private HashMap<Integer, List<Integer>> buildChildrenMap(Tree tree) {
        HashMap<Integer, List<Integer>> childrenMap = new HashMap<>();

        for (int i=0; i<tree.nodes.size(); i++) {
            int parentIndex = tree.nodes.get(i).parentIndex;

            if (childrenMap.get(parentIndex) == null) {
                childrenMap.put(parentIndex, new ArrayList<Integer>());
            }

            childrenMap.get(parentIndex).add(i);
        }

        return childrenMap;
    }
}
