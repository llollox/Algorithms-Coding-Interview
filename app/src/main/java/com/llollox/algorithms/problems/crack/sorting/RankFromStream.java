package com.llollox.algorithms.problems.crack.sorting;

import java.util.TreeMap;

public class RankFromStream {

    /*
        Imagine you are reading in a stream of integers.
        Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal to x).
        Implement the data structures and algorithms to support these operations.

        That is, implement the method:
            track(int x), which is called when each number is generated
            getRankOfNumber(int x), which returns the number of values less than or equal to x(not including x itself).

        EXAMPLE
        Stream(in order of appearance): 5,1, 4, 4, 5, 9, 7, 13, 3

        getRankOfNumber(1) : 0
        getRankOfNumber(3) : 1
        getRankOfNumber(4) : 3

     */

    public static class Ranker {
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public void track(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        public int getRankOfNumber(int x) {
            int sum = 0;
            for (int key : this.map.keySet()) {
                if (key < x) {
                    sum += map.get(key);
                }
                else if (key == x) {
                    sum += map.get(key) - 1;
                    break;
                }
                else {
                    break;
                }
            }
            return sum;
        }
    }
}
