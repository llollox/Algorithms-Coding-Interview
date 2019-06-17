package previmedical.it.leetcode.problems.crack.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

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
