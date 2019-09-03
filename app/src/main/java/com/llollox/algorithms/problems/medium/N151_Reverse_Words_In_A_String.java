package com.llollox.algorithms.problems.medium;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N151_Reverse_Words_In_A_String {

    /*
        Given an input string, reverse the string word by word.

        Example 1:
        Input: "the sky is blue"
        Output: "blue is sky the"

        Example 2:
        Input: "  hello world!  "
        Output: "world! hello"

        Explanation: Your reversed string should not contain leading or trailing spaces.

        Example 3:
        Input: "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

        Note:
        A word is defined as a sequence of non-space characters.
        Input string may contain leading or trailing spaces.
        However, your reversed string should not contain leading or trailing spaces.
        You need to reduce multiple spaces between two words to a single space in the reversed string.

        N = length of the string
     */


    /*
        Questions:
            - Does the string fit in memory? Yes
            - What if the string is empty or null? Return null
     */

    /*
        Approach 1:
            - Scan each word into the string O(N)
                - Scorrere la stringa con due puntatori:
                - Al primo non white space che trovo fermo il primo puntatore
                - Al prossimo whitespace che trovo fermo l'altro puntatore
                - Questa è una parola e la inserisco in uno stack

            - Insert it into a Stack O(1)
            - Extract all items into the stack and return them as String
     */

    public String reverseWordsPatternPointers(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int start = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (start >= 0) {
            int end = this.findFirstChar(s, start);
            if (end == -1) {
                break;
            }

            start = this.findFirstWhiteSpace(s, end);

            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(s.substring(start + 1, end + 1));
        }

        return sb.toString();
    }

    private int findFirstWhiteSpace(String s, int end) {
        while (end >= 0 && !isWhiteSpace(s.charAt(end))) {
            end -= 1;
        }

        return end;
    }

    private int findFirstChar(String s, int end) {
        while (end >= 0 && isWhiteSpace(s.charAt(end))) {
            end -= 1;
        }

        return end;
    }

    private boolean isWhiteSpace(char c) {
        return Character.isWhitespace(c);
    }


    // Pattern matching solution
    // Time O(N) Space O(N)
    public String reverseWordsPatternMatching(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        return buildString(s.trim().split("\\s+"));
    }

    private String buildString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        int n = strings.length;

        StringBuilder sb = new StringBuilder(strings[n - 1]);
        for (int i=n-2; i>=0; i--) {
            sb.append(" ").append(strings[i]);
        }

        return sb.toString();
    }
}
