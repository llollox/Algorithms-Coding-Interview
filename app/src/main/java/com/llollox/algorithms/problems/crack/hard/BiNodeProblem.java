package com.llollox.algorithms.problems.crack.hard;

public class BiNodeProblem {

    /*
        Consider a simple data structure called BiNode, which has pointers to two other nodes.
        The data structure BiNode could be used to represent both a binary tree
        (where node1 is the left node and node2 is the right node) or a doubly linked list
        (where node1 is the previous node and node2 is the next node).
        Implement a method to convert a binary search tree (implemented with BiNode)
        into a doubly linked list.
        The values should be kept in order and the operation should be performed in place
        (that is, on the original data structure).
     */

    /*
        HEAD = null;
        TAIL = null;

        DFS in Order visit  O(N)
            if (node.left == null && node.right == null && head == null && tail == null)
                ritorno new LL(node, node);

            Head = null;

            if node.left != null
                LL ll = DFS(node.left)
                Assegno come mio predecessore(left) la TAIL
                Assegno come successore della TAIL me.
                head = ll.head;

            if head == null
                head = me;

            Tail = null;

            if node.right != null
                LL ll = DFS(node.right)
                Assegno come mio successore la HEAD.
                Assegno come predecessore della HEAD me.
                tail = ll.tail;

            if tail == null
                tail = me;

            ritorno new LL(head, tail);


              HEAD
       null <- 1  <-> 3 -> 4 <-> 5

                    5
               3        7
          1    4    6

     */

    public static class BiNode {
        public int value;
        public BiNode left = null;
        public BiNode right = null;

        public BiNode(int val) {
            this.value = val;
        }
    }

    private static class LL {
        BiNode head;
        BiNode tail;

        LL(BiNode head, BiNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }


    public BiNode BSTtoLL(BiNode root) {
        if (root == null) {
            return null;
        }
        LL ll = BSTtoll(root);
        return ll.head;
    }

    private LL BSTtoll(BiNode node) {
        if (node.left == null && node.right == null) {
            return new LL(node, node);
        }

        BiNode head = null;
        if (node.left != null) {
            LL llLeft = BSTtoll(node.left);
            BiNode tail = llLeft.tail;
            tail.right = node;
            node.left = tail;
            head = llLeft.head;
        }

        if (head == null) {
            head = node;
        }

        BiNode tail = null;
        if (node.right != null) {
            LL llRight = BSTtoll(node.right);
            BiNode llHead = llRight.head;
            llHead.left = node;
            node.right = llHead;
            tail = llRight.tail;
        }

        if (tail == null) {
            tail = node;
        }

        return new LL(head, tail);
    }


}
