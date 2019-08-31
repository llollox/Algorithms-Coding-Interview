package com.llollox.algorithms.problems.easy;

public class N58_LengthOfLastWord {


    /*

        Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
        return the length of last word in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a character sequence consists of non-space characters only.

        Example:
        Input: "Hello World"
        Output: 5


        Splitto la stringa in sottostringhe dividendola per ' ' e restituisco la lunghezza dell'ultima.
        Time: O(N)
        Space: O(N)

     */

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        String[] splitted = s.split(" ");

        switch (splitted.length) {
            case 0: return 0;
            case 1: return splitted[0].length();
            default: return splitted[splitted.length - 1].length();
        }
    }

    // Looppo su tutti i caratteri, quando trovo un carattere ' ' azzero il count e salvo il massimo.

    public int lengthOfLastWordSimplified(String s) {
        int count = 0;
        int index = 0;

        while (index < s.length()) {

            // Ho trovato un carattere -> Inizio a contare
            if (s.charAt(index) != ' ') {

                int j = index;

                // Fin che trovo caratteri incremento il contatore
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }

                count = j - index;
                index = j;
            }

            index++;
        }

        return count;
    }
}
