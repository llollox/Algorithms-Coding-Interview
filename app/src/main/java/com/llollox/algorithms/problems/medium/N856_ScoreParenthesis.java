package com.llollox.algorithms.problems.medium;

import java.util.Stack;

public class N856_ScoreParenthesis {

    /*
        Given a balanced parentheses string S, compute the score of the string based on the following rule:

        () has score 1
        AB has score A + B, where A and B are balanced parentheses strings.
        (A) has score 2 * A, where A is a balanced parentheses string.


        Example 1:
        Input: "()"
        Output: 1

        Example 2:
        Input: "(())"
        Output: 2

        Example 3:
        Input: "()()"
        Output: 2

        Example 4:
        Input: "(()(()))"
        Input: 2 * "()(())" = 2 * (1 + 2 * (1))

        Output: 6


              *
           +      2
        1     *
            1   2

     */

    /*
        Questions
        - Does the string fit in memory? Yes
        - What if s is null or empty? Return 0
        - What if s is not balanced? Assume it is.
     */

    /*

        Approach 2 Tree


        Input: "(()(()))"
        Approach

        *score(0)
            index = 0
            fine = 7
            ritorno (2 * score(index + 1)) + score(fine + 1)

        *score(fine + 1 = 8) = 0

        *score(index + 1 = 1)
            fine = 2
            ritorno 1 + score(3)

        *score(3)
            fine = 6
            ritorno (2 * score(4)) + score(7)

        *score(4)
            fine = 5
            ritorno 1 + score(6)



        - Se index > length
            return 0

        - Se trovo "("
            - fine = Calcolo l'indice di dove finirà il mio calcolo

            - Se fine == index + 1
                - ritorno 1 + score(index + 2)
            - Altrimenti
                - ritorno (2 * il risultato di score(index + 1, new Stack())
                           + score (index del prossimo inizio, new Stack())

        - Se trovo ")":
            - ritorno 0

            - se il mio stack ha 1 solo elemento "(": ritorno 1
            - altrimenti:




        - Trovo "(":
            - Se lo stack è vuoto o il top dello stack è ")":
                - Inserisco la parentesi "(" nello stack
                - Proseguo

            - Se il top dello stack è "(":
                - ritorno 2 * il risultato proseguendo

         - Trovo ")"
            - Se il top dello stack è ")":
                - rimuovo la coppia dallo stack
                - next index = index + 2
                - ritorno 1
     */

    public int scoreOfParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        return score(s, 0);
    }

    private int score(String s, int index) {
        if (index >= s.length() || s.charAt(index) == ')') {
            return 0;
        }

        int end = this.getEndIndex(s, index);

        if (end == -1) {
            return 0; // ERRORE
        }

        if (end == index + 1) {
            return 1 + score(s, index + 2);
        }
        else {
            return (2 * score(s, index + 1)) + score(s, end + 1);
        }
    }

    private int getEndIndex(String s, int index) {
        if (s.charAt(index) == ')') {
            return -1;
        }

        int numOpen = 1;
        index += 1;

        while (numOpen > 0 && index < s.length()) {
            char c = s.charAt(index);
            if (c == ')') {
                numOpen -= 1;
            }
            else {
                numOpen += 1;
            }

            index += 1;
        }

        if (numOpen > 0) {
            return -1;
        }

        return index - 1;
    }
}
