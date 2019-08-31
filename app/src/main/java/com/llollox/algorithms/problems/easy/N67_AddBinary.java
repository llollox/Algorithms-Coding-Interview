package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N67_AddBinary {

    /*

        Given two binary strings, return their sum (also a binary string).

        The input strings are both non-empty and contains only characters 1 or 0.

        Example 1:

        Input: a = "11", b = "1"
        Output: "100"
        Example 2:

        Input: a = "1010", b = "1011"
        Output: "10101"

     */

    /*
        O(s) dove s è la stringa di lunghezza minima.

        Parto dal fondo dei numeri ed inizio a sommarli bit per bit.
        Se alla posizione i:
           - sono entrambi 0: scrivo il valore del resto e vado alla posizione successiva. Resto = 0.
           - sono 1 e 0:
              - Se il resto è 0: scrivo 1 e vado alla posizione successiva. Resto = 0.
              - Se il resto è 1: scrivo 0 e vado alla posizione successiva. Resto = 1.
           - sono entrambi 1: Scrivo il valore del resto e vado alla posizione successiva. Resto = 1.
           - Se ad una iterazione t, una delle due stringhe è finita e non ha alcun valore, allora:
              - Faccio i calcoli per scrivere il valore da quell'indice, considero il suo valore a quell'indice = 0
              - Copio i valori restanti dalla stringa di lunghezza massima.

        Se una volta arrivato alla fine ho il resto = 1.
        Devo aggiungere un 1 all'inizio della stringa.
     */

    public String addBinary(String a, String b) {


        int rest = 0;
        StringBuilder sb = new StringBuilder();
        String longest;
        String shortest;

        if (a.length() > b.length()) {
            longest = a;
            shortest = b;
        }
        else {
            longest = b;
            shortest = a;
        }


        for (int offset=1; offset <= longest.length(); offset++) {

            int longestIndex = longest.length() - offset;
            int shortestIndex = shortest.length() - offset;

            char valLongest = longest.charAt(longestIndex);
            char valShortest = '0';

            if (shortestIndex >= 0) {
                valShortest = shortest.charAt(shortestIndex);
            }

            if (valLongest == '0' && valShortest == '0') {
                sb.insert(0, rest);
                rest = 0;
            }
            else if (valLongest == '1' && valShortest == '1') {
                sb.insert(0, rest);
                rest = 1;
            }
            else {
                sb.insert(0, rest == 0 ? 1 : 0);
            }

        }


        if (rest == 1) {
            sb.insert(0, rest);
        }

        return sb.toString();
    }


    public void test() {

        String input1a = "11";
        String input1b = "1";
        String output1 = this.addBinary(input1a, input1b);
        Log.w("TEST", output1 + " ==? 100");

        String input2a = "1010";
        String input2b = "1011";
        String output2 = this.addBinary(input2a, input2b);
        Log.w("TEST", output2 + " ==? 10101");
    }
}
