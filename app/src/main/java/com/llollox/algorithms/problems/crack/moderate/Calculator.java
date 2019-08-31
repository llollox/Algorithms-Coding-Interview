package com.llollox.algorithms.problems.crack.moderate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public double calculate(String formula) {
        Pattern pattern = Pattern.compile("(\\d+([*/]\\d+)*)+");
        Matcher matcher = pattern.matcher(formula);
        double total = 0;
        while(matcher.find()) {
            double value = this.calculateFormula(matcher.group());
            if (matcher.start() == 0) {
                total = value;
            }
            else {

                if (formula.charAt(matcher.start() - 1) == '+') {
                    total += value;
                }
                else {
                    total -= value;
                }
            }
        }
        return total;
    }


    private double calculateFormula(String formula) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher match = pattern.matcher(formula);
        double total = 0;

        while(match.find()) {
            int value = Integer.parseInt(match.group());
            if (match.start() == 0) {
                total = value;
            }
            else {
                if (formula.charAt(match.start() - 1) == '*') {
                    total = total * value;
                }
                else {
                    total = total / value;
                }
            }
        }
        return total;
    }


}
