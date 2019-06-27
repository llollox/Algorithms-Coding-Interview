package previmedical.it.leetcode.problems.crack.dynamic;

import java.util.HashSet;
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

}
