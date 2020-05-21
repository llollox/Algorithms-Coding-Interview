package com.llollox.algorithms.problems.crack.strings;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

public class URLify {

    /*
        Write a method to replace all spaces in a string with '%20'.
        You may assume that the string has sufficient space at the end to hold the additional characters,
        and that you are given the "true" length of the string.
        (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)

        EXAMPLE
        Input: "Mr John Smith ", 13
        Output: "Mr%20John%20Smith"
     */

    public String urlify(String s) {
        char[] charArray = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        Character prev = null;

        for (int i=0;i<s.length(); i++) {
            char c = charArray[i];
            if (c == ' ') {
                if ((prev == null || prev != ' ')) {
                    queue.add('%');
                    queue.add('2');
                    queue.add('0');
                }
            }
            else {
                queue.add(c);
            }

            char peek = queue.remove();
            charArray[i] = peek;

            prev = peek;
        }

        return new String(charArray);
    }

    /*
        Write a method to replace all spaces in a string with '%20'.
        You may assume that the string has sufficient space at the end to hold the additional characters,
        and that you are given the "true" length of the string.
        (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)

        EXAMPLE
        Input: "Mr John Smith     ", 13
        Output: "Mr%20John%20Smith"

        i = puntatore nella stringa inizializzato a length -1
        j = puntatore nel buffer = actual length -1
        loop from i = length -1 to 0 compreso
            se s[i] == ' ' allora
                buff[j--] = 0
                buff[j--] = 2
                buff[j--] = %
            altrimenti
                buff[j--] = s[i]
     */

    public String urlifyImproved(String s, int length) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        char[] buff = s.toCharArray();
        int j = s.length() - 1;
        for (int i=length-1; i>=0; i--) {
            if (buff[i] == ' ') {
                buff[j--] = '0';
                buff[j--] = '2';
                buff[j--] = '%';
            }
            else {
                buff[j--] = buff[i];
            }
        }

        return new String(buff);
    }

    public void test() {
        String input = "Mr John Smith    ";
        String output = "Mr%20John%20Smith";
        Log.w("TEST", this.urlify(input) + " ==? " + output);
    }
}
