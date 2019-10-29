package com.llollox.algorithms.problems.medium;

import java.util.HashMap;

public class N166_FractionToRecurringDecimal {

    /*
    Given two integers representing the numerator and denominator of a fraction,
    return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.

    Example 1:
    Input: numerator = 1, denominator = 2
    Output: "0.5"

    Example 2:
    Input: numerator = 2, denominator = 1
    Output: "2"

    Example 3:
    Input: numerator = 2, denominator = 3
    Output: "0.(6)"
     */

    // It is not managed the case in which the rest becomes greater than MAX_INT.
    public String fractionToDecimal (int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean differentSign = differentSign(numerator, denominator);

        int division = numerator / denominator;
        if (division == 0 && differentSign) {
            result.append("-");
        }

        result.append(division);

        int rest = numerator % denominator;

        if (rest == 0) {
            return result.toString();
        }
        else if (rest < 0) {
            rest = -rest;
        }

        result.append(".");

        if (denominator < 0) {
            denominator = -denominator;
        }
        rest = rest * 10;
        int offset = result.length();

        HashMap<Integer, Integer> hm = new HashMap<>(); // Key is q / Value is the index

        while (rest > 0) {
            if (hm.containsKey(rest)) {
                int index = hm.get(rest);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }

            int d = rest / denominator;
            int newRest = rest % denominator;
            result.append(d);
            hm.put(rest, offset);
            rest = newRest * 10;
            offset = offset + 1;
        }

        return result.toString();
    }

    private boolean differentSign(int numerator, int denominator) {
        if (numerator == 0) {
            return denominator < 0;
        }
        else if (numerator > 0) {
            return denominator < 0;
        }
        else {
            return denominator > 0;
        }
    }
}
