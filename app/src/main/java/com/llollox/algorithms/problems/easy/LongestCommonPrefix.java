package com.llollox.algorithms.problems.easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        else if (strs.length == 1) {
            return strs[0];
        }

        int minLength = Integer.MAX_VALUE;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        int endIndex = 0;

        while (endIndex < minLength) {
            char c = strs[0].charAt(endIndex);

            if (!this.areAllSame(strs, endIndex)) {
                break;
            }

            endIndex++;
        }

        return strs[0].substring(0, endIndex);
    }

    private boolean areAllSame(String[] strs, int index) {
        char c = strs[0].charAt(index);

        for (int j=1;j<strs.length;j++) {
            if (c != strs[j].charAt(index)) {
                return false;
            }
        }

        return true;
    }
}
