package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.HashMap;

public class PathsWithSum {

    /*
        You are given a binary tree in which each node contains an integer value (which might be positive or negative).
        Design an algorithm to count the number of paths that sum to a given value.
        The path does not need to start or end at the root or a leaf,
        but it must go downwards (traveling only from parent nodes to child nodes).


        SUM = 3

              1
         2         4
      8    4    -1   9


        - DFS taking into account of the sum
        - At each node try:
            - To continue with the sum
            - Try resetting the sum


     */

    public int pathsWithSum(TreeNode node, int sum) {
        return pathsWithSum(node, sum, 0);
    }

    public int pathsWithSum(TreeNode node, int sum, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Try resetting sum
        int paths = pathsWithSum(node.left, sum, 0);        // Reset left
        paths += pathsWithSum(node.right, sum, 0);          // Reset right

        paths += pathsWithSum(node.left, sum, currentSum + node.val); // Continue left
        paths += pathsWithSum(node.right, sum, currentSum + node.val);// Continue right

        return paths + (currentSum + node.val == sum ? 1 : 0);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int pathWithSumReImplemented(TreeNode node, int goal) {
        if (node == null) return 0;
        return countPaths(node, 0, goal);
    }

    // count path starting from a certain node.
    private int countPaths(TreeNode node, int sum, int goal) {
        if (node == null) { return 0; }

        if (sum + node.val == goal) {
            return 1;
        }

        return countPaths(node.left, sum + node.val, goal)
                + countPaths(node.right, sum + node.val, goal)
                + countPaths(node.left, 0, goal)
                + countPaths(node.right, 0, goal);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int pathWithSumOptimal(TreeNode node, int goal) {
        if (node == null) return 0;
        return pathWithSumDfs(node, goal, new HashMap<Integer, Integer>(), 0);
    }

    private int pathWithSumDfs(TreeNode node, int goal, HashMap<Integer, Integer> sumCount, int sum) {
        if (node == null) return 0;

        sum += node.val;

        int res = sumCount.getOrDefault(sum - goal, 0);

        if (sum == goal) {
            res++;
        }

        increment(sumCount, sum);
        res += pathWithSumDfs(node.left, goal, sumCount, sum);
        res += pathWithSumDfs(node.right, goal, sumCount, sum);
        decrement(sumCount, sum);

        return res;
    }

    private void increment(HashMap<Integer, Integer> map, int key) {
        int value = map.getOrDefault(key, 0) + 1;
        map.put(key, value);
    }

    private void decrement(HashMap<Integer, Integer> map, int key) {
        int value = map.getOrDefault(key, 0);
        if (value == 0) {
            map.remove(key);
        }
        else {
            map.put(key, value - 1);
        }
    }
}
