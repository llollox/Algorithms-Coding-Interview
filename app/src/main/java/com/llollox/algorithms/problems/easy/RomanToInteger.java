package com.llollox.algorithms.problems.easy;

public class RomanToInteger {


    public int convert(String s) {

        if (s.length() == 0) {
            return 0;
        }
        else if (s.length() == 1) {
            return this.convert(s.charAt(0));
        }

        int count = 0;


        for (int start=0; start < s.length(); start++) {

            if (start == s.length() - 1) {
                count += convert(s.charAt(start));
            }
            else {
                int couple = this.convert(s, start, start + 1);

                if (couple == -1) {
                    count += convert(s.charAt(start));
                }
                else {
                    count += couple;
                    start++;
                }
            }

        }
        return count;
    }

    private int convert(String s, int start, int end) {

        switch (s.charAt(start)) {

            case 'I':
                switch (s.charAt(end)) {
                    case 'V': return 4;
                    case 'X': return 9;
                    default: return -1;
                }

            case 'X':
                switch (s.charAt(end)) {
                    case 'L': return 40;
                    case 'C': return 90;
                    default: return -1;
                }

            case 'C':
                switch (s.charAt(end)) {
                    case 'D': return 400;
                    case 'M': return 900;
                    default: return -1;
                }

            default: return -1;

        }
    }

    private int convert(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
