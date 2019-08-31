package com.llollox.algorithms.problems.medium;

import android.util.Log;

public class N43_MultiplyStrings {

    /*
    Given two non-negative integers num1 and num2 represented as strings,
    return the product of num1 and num2, also represented as a string.

    Example 1:

    Input: num1 = "2", num2 = "3"
    Output: "6"
    Example 2:

    Input: num1 = "123", num2 = "456"
    Output: "56088"

    Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */


    /*
        Solution O(num1.length * num2.length)

          93 *
          24 =
        ------
          52
         26-
        ------
         312


         Utilizzando uno SB.

         In order to minimize the effort i try to understand which is the shortest string.
         Multiplied is the longest and multiplier is the shortest.


         for every element of the shortest string, starting by the last element.
         The index of the element is the offset by which the elements must be summed into the SB.

         reminder = 0;

         Multiply it with all digits of longest string, starting by the end too.

            Get the product = num1[index] * num2[index]
            If the shortest string has finished at that index, get 1 in order to get its value.

            reminder += product

            sbPosition = offset + indexOfElementInLongest

            reminder += SB[sbPosition]

            lastDigit = reminder % 10

            SB[sbPosition] = lastDigit

            reminder = reminder / 10

             Therefore I take 4 and the 3, multiply it: 12.
             Sum the reminder(0), still 12.
             Then take the last digit, 2 and save to the last position. "2"
             Than divide the reminder by 10 and save it as reminder = 1.
             Than go for the second digit of the longest string (1).

             Take always 4 and multiply by 1: 4.
             Sum the reminder(1), get 5.
             Take the last digit, 5. and save it to position 1. "25"
             Divide the reminder by 10 and save it = 0.

         Take the second element of the shortest string (2).
         In this case the offset is 1,
         this means that all the summations into the SB start by position 1.

         Multiply 2 with the last element of the longest(3) = 6.
         Sum the reminder(0), still 6.
         Sum 6 to offset + position = SB[1] (5), get 11.
         Save last digit(1), divide the reminder by 10 and sum it to the next position. (211)

         Multiply 2 with the element 1 of the longest(1) = 2.
         Sum the reminder(0), still 2.
         Sum 2 to offset + position = SB[2] (1), get 3.
         Save last digit(3), divide the reminder by 10 and sum it to the next position. (213)


         Reverse the string and return it

     */

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String longest;
        String shortest;

        StringBuilder sb = new StringBuilder();

        if (num1.length() < num2.length()) {
            longest = num2;
            shortest = num1;
        }
        else {
            longest = num1;
            shortest = num2;
        }

        int reminder = 0;
        int sbOffset = 0;

        for (int indexShortest=shortest.length()-1; indexShortest >=0; indexShortest--) {

            int valShortest = this.map(shortest.charAt(indexShortest));

            int sbPosition = sbOffset;
            reminder = 0;

            for (int indexLongest=longest.length()-1; indexLongest >=0; indexLongest--) {

                int valLongest = this.map(longest.charAt(indexLongest));
                int product = valShortest * valLongest;

                reminder += product;

                int sbValue = sbPosition < sb.length() ? this.map(sb.charAt(sbPosition)) : 0;

                reminder += sbValue;

                int lastDigit = reminder % 10;

                if (sbPosition < sb.length()) {
                    sb.setCharAt(sbPosition, this.map(lastDigit));
                }
                else {
                    sb.append(this.map(lastDigit));
                }

                sbPosition++;
                reminder = reminder / 10;
            }

            if (reminder > 0) {
                sb.append(this.map(reminder));
            }

            sbOffset++;
        }

        sb.reverse();

        return sb.toString();
    }


    private char map(int n) {
        switch (n) {
            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            default: throw new RuntimeException("Unknown int");
        }
    }

    private int map(char c) {
        switch (c) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: throw new RuntimeException("Unknown char");
        }
    }

    public void test() {
//        String input1a = "999";
//        String input2b = "999";
//        String output = this.multiply(input1a, input2b);
//        Log.w("TEST", output + " ==? 998001");

        String input2a = "123";
        String input2b = "456";
        String output = this.multiply(input2a, input2b);
        Log.w("TEST", output + " ==? 56088");
    }
}
