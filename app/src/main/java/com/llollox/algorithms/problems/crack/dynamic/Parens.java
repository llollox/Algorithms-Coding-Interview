package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parens {

    /*
        Implement an algorithm to print all valid
        (i.e., properly opened and closed) combinations of n pairs of parentheses.
     */


    public Set<String> generateParensRecursive(int remaining) {

        if (remaining < 0) {
            return new HashSet<>();
        }

        Set<String> set = new HashSet<>();

        if (remaining == 0) {
            set.add("");
        }
        else {

            Set<String> prev = generateParensRecursive(remaining - 1);

            for (String str : prev) {

                for (int i=0; i<str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }

        return set;
    }

    private String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1);
        return left + "()" + right;
    }



    /*
        Solution without duplicates.

        Keep track of left remaining and right remaining.

        Base case FAILURE:
        If left ramaining < 0 || left remaining < right remaining => return because it's a syntax error.

        Base case SUCCESS:
        If left remaining == 0 && right remaining == 0 => Add to set of successes.

        Recursive step
        Try to add '(' and then, remove 1 left remaining and recurse
        Try to add ')' and then, remove 1 right remaining and recurse

        Time O(2^n) Space O(2^n)
     */
    public Set<String> generateParensWithoutDupsRecursive(int remaining) {

        Set<String> set = new HashSet<>();

        char[] str = new char[remaining * 2];

        if (remaining <= 0) {
            return set;
        }

        generateParensWithoutDupsRecursive(set, remaining, remaining, str, 0);

        return set;
    }


    private void generateParensWithoutDupsRecursive(
            Set<String> set, int leftRemains, int rightRemains, char[] str, int index) {

        if (leftRemains < 0 || leftRemains > rightRemains) {
            return;
        }

        if (leftRemains == 0 && rightRemains == 0) {
            set.add(String.copyValueOf(str));
        } else {

            str[index] = '(';
            generateParensWithoutDupsRecursive(set, leftRemains - 1, rightRemains, str, index + 1);

            str[index] = ')';
            generateParensWithoutDupsRecursive(set, leftRemains, rightRemains - 1, str, index + 1);

        }
    }



    /*
        Generate parens new try
     */

    public Set<String> parensNew(int n) {
        if (n <= 0) {
            return new HashSet<>();
        }
        else if (n == 1) {
            Set<String> set = new HashSet<>();
            set.add("()");
            return set;
        }
        else {

            Set<String> prev = parensNew(n - 1);
            Set<String> next = new HashSet<>();

            for (String s : prev) {

                next.add("()" + s);
                next.add(s + "()");

                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i< sb.length(); i++) {
                    if (sb.charAt(i) == '(') {

                        sb.insert(i + 1, "()");
                        next.add(sb.toString());
                        sb.delete(i + 1, i + 3);
                    }
                }
            }

            return next;
        }
    }


    public Set<String> parensWithoutDupsNew(int n) {
        if (n <= 0) {
            return new HashSet<>();
        }
        return this.parensWithoutDupsNew(n, n, new StringBuilder(), new HashSet<String>());
    }

    public Set<String> parensWithoutDupsNew(int openRem, int closeRem, StringBuilder sb, Set<String> set) {

        if (openRem == 0 && closeRem == 0) {
            set.add(sb.toString());
        }
        else {

            if (openRem > 0) {
                sb.append("(");
                parensWithoutDupsNew(openRem - 1, closeRem, sb, set);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (closeRem > 0 && closeRem > openRem) {
                sb.append(")");
                parensWithoutDupsNew(openRem, closeRem - 1, sb, set);
                sb.deleteCharAt(sb.length() - 1);
            }

        }

        return set;
    }



    // Optmial Version *************************************************************************************************
    /*
     Note
     - What if n <= 0, return empty array

     Approach 1  Time O(2n) Space O(n)
     - Given n means have at most n opening parens and n closing parens
     - Try to construct all the combinations of parens recursively
     - If opening and closing are 0
        - This means we have no more parens left and therefore we can add that solution to the array
     - Otherwise if opening > 0
        - (this means we have the possibility to add a new opening parenthesis)
        - Continue add that parenthesis and reduce the number of opening parens by 1.
     - Otherswise if opening < closing,
        - (this means we can safely add a closing parenthesis)
        - continue adding a closing parenthesis and reduce the number of closing parens by 1.
      */

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        if(n < 1) {
            return ans;
        }

        dfsHelper(n, n, new StringBuilder(), ans);
        return ans;
    }

    private void dfsHelper(int open, int close,  StringBuilder sb, List<String> ans){

        if(open == 0 && close == 0) {
            ans.add(sb.toString());
        }

        if(open > 0){
            sb.append('(');
            dfsHelper(open - 1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open < close){
            sb.append(')');
            dfsHelper(open, close - 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<String> parensReImplemented(int n) {
        ArrayList<String> solutions = new ArrayList<>();
        parensReImplemented(n, n, new StringBuilder(), solutions);
        return solutions;
    }

    private void parensReImplemented(
            int opensLeft, int closedLeft, StringBuilder sb, ArrayList<String> solutions) {
        if (opensLeft == 0 && closedLeft == 0) {
            solutions.add(sb.toString());
            return;
        }

        if (opensLeft > 0) {
            sb.append("(");
            parensReImplemented(opensLeft -1, closedLeft, sb, solutions);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (opensLeft < closedLeft && closedLeft > 0) {
            sb.append(")");
            parensReImplemented(opensLeft, closedLeft - 1, sb, solutions);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
