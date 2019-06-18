package previmedical.it.leetcode.problems.crack.stacks;

import java.util.Stack;

public class StackMin extends Stack<Integer> {


    /*
        Stack Min: How would you design a stack which,
        in addition to push and pop,
        has a function min which returns the minimum element?
        Push, pop and min should all operate in 0(1) time.
     */


    Stack<Integer> minStack = new Stack<>();

    @Override
    public Integer push(Integer item) {
        Integer output = super.push(item);

        if (item < min()) {
            minStack.push(item);
        }

        return output;
    }


    @Override
    public synchronized Integer pop() {
        Integer output = super.pop();

        if (output == this.min()) {
            minStack.pop();
        }

        return output;
    }

    private int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return minStack.peek();
        }
    }
}
