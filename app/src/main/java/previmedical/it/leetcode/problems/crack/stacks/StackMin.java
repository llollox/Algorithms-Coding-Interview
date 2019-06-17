package previmedical.it.leetcode.problems.crack.stacks;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

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
