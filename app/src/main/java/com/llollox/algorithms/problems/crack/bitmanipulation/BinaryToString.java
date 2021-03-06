package com.llollox.algorithms.problems.crack.bitmanipulation;

public class BinaryToString {

    /*
        Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
        If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR"
     */

    public String binaryToString(double num) {

        if (num <= 0 || num >= 1) {
            throw new RuntimeException();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(".");

        while (num > 0) {

            double r = num * 2;
            if (r >= 1) {
                sb.append("1");
                num = r - 1;
            }
            else {
                sb.append("0");
                num = r;
            }
        }

        return sb.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public String binaryToStringReImplemented(double d) {
        if (d <= 0 || d >= 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append(".");

        while (d > 0) {
            d = d * 2;

            if (d >= 1) {
                sb.append("1");
                d = d - 1;
            }
            else {
                sb.append("0");
            }
            count += 1;

            if (count > 32) {
                return "ERROR";
            }
        }

        return sb.toString();
    }
}
