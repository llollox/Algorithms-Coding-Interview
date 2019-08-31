package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N61_PlusOne {

    /*

    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
     */

    /*
        Soluzione. O(n)
        Parto dalla fine e:
            - se trovo un valore != 9 -> aumento di uno quel valore e ritorno
            - se trovo == 9 -> sostituisco con 0 e ripeto col successivo fino ad arrivare all'ultimo valore.

        Se sono arrivato fino alla fine e sono tutti 9, allora aggiungo 1 all'inizio e ritorno.
        Cio' comporta dover reistanziare un nuovo array con 1 come primo valore e 0 in tutti gli altri.

     */

    public int[] plusOne(int[] digits) {

        for (int i=digits.length - 1; i>=0; i--) {
            int val = digits[i];
            if (val == 9) {
                digits[i] = 0;
            }
            else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        // All 9's case
        int[] output = new int[digits.length + 1];
        output[0] = 1;
        return output;
    }


    public void test() {

        int[] input1 = {1,2,3};
        int[] output1 = this.plusOne(input1);
        Log.w("TEST", output1.toString() + " == ? [1,2,4]");

        int[] input2 = {4,3,2,1};
        int[] output2 = this.plusOne(input2);
        Log.w("TEST", output2.toString() + " == ? [4,3,2,2]");
    }
}
