package com.llollox.algorithms.problems.crack.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianKeeper {

    private PriorityQueue<Integer> smaller = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    });
    private PriorityQueue<Integer> greater = new PriorityQueue<>();


    int getMedian() {
        if (greater.size() > smaller.size()) {
            return greater.peek();
        }
        else if (greater.size() < smaller.size()) {
            return smaller.peek();
        }
        else if (smaller.size() > 0) {
            return (smaller.peek() + greater.peek()) / 2;
        }
        return 0;
    }

    void addValue(int x) {
        int median = getMedian();
        if (x >= median) {
            greater.add(x);
            if (greater.size() - 1 > smaller.size()) {
                smaller.add(greater.poll());
            }
        }
        else {
            smaller.add(x);
            if (smaller.size() - 1 > greater.size()) {
                greater.add(smaller.poll());
            }
        }
    }

}
