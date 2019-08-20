package previmedical.it.leetcode.problems.other;

public class NumWaysToDecode {

    /* Given a string write an algorithm to calculate in how many ways it can be decoded */


    /*
        At each iteration I can or take one digit or two digits.
     */

    public int numWays(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return 0;
        }

        return this.numWays(new StringBuilder(pattern), 0);
    }


    private int numWays(StringBuilder sb, int start) {

        if (sb.length() == start) {
            return 1;
        }
        else {
            int count = 0;

            if (sb.charAt(start) != '0') {
                count = numWays(sb, start + 1);
            }

            if (sb.substring(start).length() >= 2 && map(sb.substring(start, start + 2)) != null) {
                count = count + numWays(sb, start + 2);
            }

            return count;
        }
    }


    private String map(String s) {
        switch (s) {
            case "1": return "a";
            case "2": return "b";
            case "3": return "c";
            case "4": return "d";
            case "5": return "e";
            case "6": return "f";
            case "7": return "g";
            case "8": return "h";
            case "9": return "i";
            case "10": return "j";
            case "11": return "k";
            case "12": return "l";
            case "13": return "m";
            case "14": return "n";
            case "15": return "o";
            case "16": return "p";
            case "17": return "q";
            case "18": return "r";
            case "19": return "s";
            case "20": return "t";
            case "21": return "u";
            case "22": return "v";
            case "23": return "w";
            case "24": return "x";
            case "25": return "y";
            case "26": return "z";
            default: return null;
        }
    }


}
