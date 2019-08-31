package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N28_strStr {

    // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    // What should we return when needle is an empty string? This is a great question to ask during an interview.
    // For the purpose of this problem, we will return 0 when needle is an empty string.
    // This is consistent to C's strstr() and Java's indexOf().

    // INPUT haystack = "hello", needle = "ll"
    // OUTPUT 2

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        char startChar = needle.charAt(0);

        for (int i=0; i<= haystack.length() - needle.length(); i++) {

            if (startChar == haystack.charAt(i)) {
                int k = 1;
                int j = i + k;

                while (k < needle.length() && haystack.charAt(j) == needle.charAt(k)) {
                    k++;
                    j++;
                }

                if (k == needle.length()) { // found
                    return i;
                }
            }
        }

        return -1;
    }

    public void test() {
        String input = "hello";
        String needle = "hello";

        int output = this.strStr(input, needle);

        Log.w("TEST", "" + output);
    }
}
