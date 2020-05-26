package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Time O(2^n) Space 
    public ArrayList<String> hanoiReImplemented(int n) {
        StackWithName<Integer> left = new StackWithName<>("left");
        for (int i = n; i > 0; i --) {
            left.push(i);
        }

        ArrayList<String> moves = new ArrayList();
        hanoiHelperReImplemented(
                left,
                new StackWithName<Integer>("middle"),
                new StackWithName<Integer>("right"),
                n, moves);

        return moves;
    }

    private void hanoiHelperReImplemented(
            StackWithName<Integer> left,
            StackWithName<Integer> middle,
            StackWithName<Integer> right,
            int n,
            ArrayList<String> moves) {
        switch(n) {
            case 0: return;
            case 1:
                move(left, right, moves);
                break;
            default:
                hanoiHelperReImplemented(left, right, middle, n - 1, moves);
                move(left, right, moves);
                hanoiHelperReImplemented(middle, left, right, n - 1, moves);
        }
    }

    private void move(StackWithName<Integer> from, StackWithName<Integer> to, ArrayList<String> moves) {
        String move = String.format("%s [%d] -> %s", from.name, from.peek(), to.name);
        moves.add(move);
        to.push(from.pop());
    }

}
