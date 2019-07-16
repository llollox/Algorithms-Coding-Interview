package previmedical.it.leetcode.problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class N225_ImplementStackUsingQueues {

    /*
        Implement the following operations of a stack using queues.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        empty() -- Return whether the stack is empty.
        Example:

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false

        Notes:
        You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
        Depending on your language, queue may not be supported natively.
        You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
        You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

        /**
         * Your MyStack object will be instantiated and called as such:
         * MyStack obj = new MyStack();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.top();
         * boolean param_4 = obj.empty();
         */

        /** Initialize your data structure here. */
        public static class MyStack {

            private Queue<Integer> q1 = new LinkedList<>();
            private Queue<Integer> q2 = new LinkedList<>();

            public MyStack() {
            }

            /** Push element x onto stack. */
            public void push(int x) {
                this.q1.add(x);
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {

                if (this.q1.size() > 0) {
                    this.q2.clear();

                    int q1Size = this.q1.size();
                    for (int i=0; i< q1Size - 1; i++) {
                        this.q2.add(this.q1.poll());
                    }
                    int peek = this.q1.poll();

                    int q2Size = this.q2.size();
                    for (int i=0; i< q2Size; i++) {
                        this.q1.add(this.q2.poll());
                    }

                    return peek;
                }

                return -1;
            }

            /** Get the top element. */
            public int top() {

                if (this.q1.size() > 0) {
                    this.q2.clear();

                    int q1Size = this.q1.size();
                    for (int i=0; i< q1Size - 1; i++) {
                        this.q2.add(this.q1.poll());
                    }
                    int peek = this.q1.poll();

                    int q2Size = this.q2.size();
                    for (int i=0; i< q2Size ; i++) {
                        this.q1.add(this.q2.poll());
                    }

                    this.q1.add(peek);

                    return peek;
                }

                return -1;

            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return this.q1.size() == 0;
            }
        }
}
