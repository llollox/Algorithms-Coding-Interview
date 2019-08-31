package com.llollox.algorithms.problems.crack.hard;

public class MajorityElementOptimal {

    /*
        A majority element is an element that makes up more than half of the items in an array.
        Given a positive integers array, find the majority element.

        If there is no majority element, return -1.
        Do this in O(N) time and 0(1) space.

        Input: 1 2 5 9 5 9 5 5 5

        Min = 1
        Max = 9
        Size = 9
        At least times = 5

        Sum: = 46

        Max Sum = 46 - 4 * 1 = 42
        Max value = 42 / 5 = 8


        1 non può essere perchè:
            1 * 5 = 5
            9 * 4 = 36
            in totale non fa 46, quindi non riesco ad ottenere 46 se scelgo tutti gli 1
            min = 2

        9 non può essere perchè
            9 * 5 = 45
            quindi non riesco a fare la somma di 46
            max = 8


        Trovo 1, che non può essere, e decremento sum a 45, size = 8
        2 * 5 = 10
        9 * 3 = 27, sum = 37, quindi 2 non può essere
        min = 3

        3 * 5 = 15
        9 * 3 = 27, sum = 42, quindi 3 non può essere
        min = 4

        Trovo 2, che non può essere e decremento sum a 43, size = 7
        4 * 4 = 16
        9 * 3 = 27
        Non posso dire nulla

        Trovo 5, sum = 38, size = 6





        Output: 5
     */


    public int majorityElementOptimal(int[] array) {
        if (array == null) {
            return -1;
        }
        int candidate = this.getCandidate(array);
        return this.validate(array, candidate) ? candidate : -1;
    }

    private int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;

        for (int n: array) {

            if (count == 0) {
                majority = n;
            }

            if (n == majority) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }

        return majority;
    }



    private boolean validate(int[] array, int x) {
        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] == x) {
                count += 1;
            }
        }

        return count > array.length / 2;
    }


}
