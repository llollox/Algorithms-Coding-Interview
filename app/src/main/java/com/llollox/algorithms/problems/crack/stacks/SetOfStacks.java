package com.llollox.algorithms.problems.crack.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {


    /*
         Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
         Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
         Implement a data structure SetOfStacks that mimics this.
         SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
         SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single stack
         (that is, pop() should return the same values as it would if there were just a single stack).

         FOLLOW UP
        Implement a function popAt(int index) which performs a pop operation on a specific sub­ stack.
     */

    ArrayList<Stack<Integer>> arrayList = new ArrayList<>();
    int threshold = 3;

    public int push(int n) {
        if (arrayList.isEmpty() || lastStack().size() == threshold) {
            arrayList.add(new Stack<Integer>());
        }

        return this.lastStack().push(n);
    }

    public int pop() {
        if (arrayList.isEmpty()) {
            // nothing to do
            throw new RuntimeException("Empty stack");
        }
        else {
            int output = this.lastStack().pop();

            if (this.lastStack().isEmpty()) {
                this.arrayList.remove(this.lastStack());
            }

            return output;
        }
    }

    public int popAt(int stackIndex) {
        return -1;
//        if (stackIndex < arrayList.size()) {
//
//            arrayList.get(stackIndex);
//
//            for (int i = stackIndex+1; i<arrayList.size(); i++) {
//                int value = arrayList.get(i).pop();
//                arrayList.get(i-1).push(value);
//                arrayList.get(i).removeBottom
//            }
//        }
//        else {
//            throw new RuntimeException("Index out of bounds");
//        }
    }

    private Stack<Integer> lastStack() {
        return arrayList.get(arrayList.size() - 1);
    }
}
