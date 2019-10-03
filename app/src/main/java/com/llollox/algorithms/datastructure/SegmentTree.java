package com.llollox.algorithms.datastructure;

public class SegmentTree {

    private static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private int[] array;
    private TreeNode root;

    public SegmentTree(int[] array) {
        this.array = array;
        this.root = buildSegmentTree(array);
    }

    // 1 2 3 4 5 6
    /*
           [0-5]
            21
      [0-2]     [3-5]
        6        15
   [0-1]  [2][3-4]  [5]
     3     3   9    6
   1   2  3   4  5 6

           28
        10    18
     3      7     11
   1   2  3   4  5   6
     */

    // 2-4
    public int sum(int start, int end) {
        if (start > end || start < 0 || end >= this.array.length) {
            return 0;
        }

        return sumDfs(this.root, start, end, 0, this.array.length);
    }

    /*
            [0-4]
        [0-1]    [2-4]

     */

    // 1 2 3 4 5
    private int sumDfs(TreeNode node, int start, int end, int min, int max) {
        if (start == min && end == max - 1) {
            return node.value;
        }
        else if (start == end) {
            return this.array[start];
        }
        else {
            int mid = (min + max) / 2; // 3
            if (end < mid) {
                return sumDfs(node.left, start, end, min, mid - 1);
            }
            else if (start >= mid) {
                return sumDfs(node.right, start, end, mid, max);
            }
            else {
                int leftSum = sumDfs(node.left, Math.max(start, min - 1), mid - 1, min, mid);
                int rightSum = sumDfs(node.right, mid, Math.min(end, max - 1), mid, max);
                return leftSum + rightSum;
            }
        }
    }

    private TreeNode buildSegmentTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        return buildSegmentDfs(0, array.length - 1);
    }

    private TreeNode buildSegmentDfs(int start, int end) {
        if (start == end) {
            return new TreeNode(this.array[start]);
        }

        TreeNode node = new TreeNode(this.sumArray(start, end));
        int mid = (start + end) / 2;
        node.left = buildSegmentDfs(start, mid);
        node.right = buildSegmentDfs(mid + 1, end);
        return node;
    }

    private int sumArray(int start, int end) {
        int sum = 0;
        for (int i=start; i<=end; i++) {
            sum += this.array[i];
        }
        return sum;
    }
}
