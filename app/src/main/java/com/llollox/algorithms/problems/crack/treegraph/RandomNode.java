package com.llollox.algorithms.problems.crack.treegraph;

import com.llollox.algorithms.models.TreeNode;

import java.util.Random;

public class RandomNode {

    /*
        You are implementing a binary search tree class from scratch, which, in addition to insert, find, and delete,
        has a method getRandomNode() which returns a random node from the tree.
        All nodes should be equally likely to be chosen.
        Design and implement an algorithm for getRandomNode,
        and explain how you would implement the rest of the methods.
     */


    public TreeNode randomNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        int numNodes = this.getNumNodes(node);

        if (this.randomNumber(1, numNodes) == 1) {
            return node;
        }
        else {
            if (this.randomNumber(0, 1) == 0) {
                return this.randomNode(node.left);
            }
            else {
                return this.randomNode(node.right);
            }
        }
    }


    private int randomNumber(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min + 1);
    }


    private int getNumNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getNumNodes(node.left);
        int right = getNumNodes(node.right);

        return left + right + 1;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

   /*
        Secondo approccio.
        Ritornare un numero random da 0 alla grandezza dell'albero.
        Ritornare l'i-esimo nodo dato da una visita in-order.
    */

   public static class Counter {
       int value;

       public Counter(int value) {
           this.value = value;
       }

       public void increment() { value += 1; }
   }

   public TreeNode getRandomNodeInOrderTraversal(TreeNode node) {
       if (node == null) {
           return null;
       }

       int size = getSize(node);

       Random random = new Random();
       int index = random.nextInt(size);
       return getIthNode(node, new Counter(-1), index);
   }

   public TreeNode getIthNode(TreeNode node, Counter counter, int indexToBeFound) {
       if (node == null) {
           return null;
       }

       TreeNode left = getIthNode(node.left, counter, indexToBeFound);
       if (left != null) {
            return left;
       }

       counter.increment();
       if (counter.value == indexToBeFound) {
           return node;
       }

       return getIthNode(node.right, counter, indexToBeFound);
   }

   private int getSize(TreeNode node) {
       if (node == null) {
           return 0;
       }

       return getSize(node.left) + getSize(node.right) + 1;
   }
}
