package com.llollox.algorithms.problems.easy;

import java.util.Stack;

public class N20_ValidParenthesis {

    public boolean validParenthesis(String s) {

        Stack<String> stack = new Stack<>();
        int mid = s.length() / 2;

        for (int i=0; i<s.length();i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') { // is opening
                stack.push("" + c);

                if (stack.size() > mid) {
                    return false;
                }
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    char top = stack.peek().charAt(0);

                    char opening = 'z';

                    switch (c) {
                        case ')': opening = '('; break;
                        case '}': opening = '{'; break;
                        case ']': opening = '['; break;
                    }

                    if (top == opening) {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
