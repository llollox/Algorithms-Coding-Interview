package previmedical.it.leetcode.problems.crack.stacks;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public int enqueue(int value) {
        this.s1.push(value);
        return value;
    }


    public int dequeue() {
        if (s1.isEmpty()) {
            throw  new RuntimeException("MyQueue is empty");
        }
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int peek = s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return peek;
        }
    }


    public int peek() {
        if (s1.isEmpty()) {
            throw  new RuntimeException("MyQueue is empty");
        }
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int peek = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return peek;
        }
    }
}
