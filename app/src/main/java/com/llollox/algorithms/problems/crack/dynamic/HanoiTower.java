package com.llollox.algorithms.problems.crack.dynamic;

import java.util.Stack;

public class HanoiTower {


    class StackWithName<T> extends Stack<T> {
        String name;

        public StackWithName(String name) {
            this.name = name;
        }
    }

    public void hanoiTower(int n) {

        StackWithName<Integer> left = new StackWithName<>("Left");
        for (int i=n; i>=1; i--) {
            left.push(i);
        }

        StackWithName<Integer> center = new StackWithName<>("Center");
        StackWithName<Integer> right = new StackWithName<>("Right");
        this.hanoiTower(left, center, right, n);
    }

    private void hanoiTower(StackWithName<Integer> left, StackWithName<Integer> center, StackWithName<Integer> right, int size) {
        if (size == 1) {
            this.move(left, right);
        }
        else {
            this.hanoiTower(left, right, center, size - 1);
            this.move(left, right);
            this.hanoiTower(center, left, right, size - 1);
        }
    }

    private void move(StackWithName<Integer> from, StackWithName<Integer> to) {
        Integer peek = from.pop();
        System.out.println("Move "  + peek + ": " + from.name + " --> " + to.name);
        to.push(peek);
    }

}
