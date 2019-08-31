package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N541_ReverseString2 {

    /*

        Given a string and an integer k, you need to reverse the first k characters
        for every 2k characters counting from the start of the string.

        If there are less than k characters left, reverse all of them.
        If there are less than 2k but greater than or equal to k characters,
        then reverse the first k characters and left the other as original.

        Example:
        Input: s = "abcdefg", k = 2
        Output: "bacdfeg"

        Restrictions:
        The string consists of lower English letters only.
        Length of the given string and k will in the range [1, 10000]
     */

    /*
        Calcolo quanti slot da invertire ci sono (s.length() / 2k)
        Per ogni slot, inverto i primi k.
        Arrivato infondo inverto la parte rimanete della stirnga.
     */


    public String reverseStr(String s, int k) {

        int slotLength = 2 * k;
        int slots = s.length() / slotLength;
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i< slots; i++) {

            int start = i * slotLength;
            int end = start + k;
            this.reverse(sb, start, end);
        }

        int rest = s.length() % slotLength;
        int charactersToReverse = Math.min(k, rest);

        int start = slotLength * slots;
        int end = start + charactersToReverse;

        this.reverse(sb, start, end);

        return sb.toString();
    }

    // Per invertire una stringa dati due indici.

    // 3 e 5
    // lunghezza 5 - 3 = 2
    // loop 2 / 2 = 1 volte
    // reverseIndex = end - i -1;
    // temp = start + i
    // s[start + i] = s[reverseIndex]
    // s[reverseIndex] = temp

    private void reverse(StringBuilder s, int start, int end) {

        int length = end - start;

        for (int i=0; i< length / 2; i++) {
            int reverseIndex = (end - i - 1);
            char temp = s.charAt(i + start);
            s.setCharAt(i + start, s.charAt(reverseIndex));
            s.setCharAt(reverseIndex, temp);
        }
    }

    public void test() {
        String output = this.reverseStr("abcdefg", 2);
        Log.w("TEST", output);
    }
}
