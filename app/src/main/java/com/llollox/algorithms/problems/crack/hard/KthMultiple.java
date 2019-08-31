package com.llollox.algorithms.problems.crack.hard;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthMultiple {

    /*
        Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
        Note that 3, 5, and 7 do not have to be factors, but it should not have any other prime factors.
        For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
     */

    /*

        Solution given k.

        NOTES
        Each number must be odd
        Start with 1 and add 2 every time.


        - if k == 0, return 0;
        - Count = 0;
        - Value = 0;

        O (k)
        - while count < k
            check if number is Valid
                - TRUE: count + 1; value = number;
                - FALSE: do nothing
            value = value + 2;


        O(1)
        isValid() {
            // check if
        }
     */


    // Time O(N) *******************************************************************************
    public int kthMultipleOptimal(int k) {
        if (k <= 0) {
            return -1;
        }

        LinkedList<Integer> q3 = new LinkedList<>();
        LinkedList<Integer> q5 = new LinkedList<>();
        LinkedList<Integer> q7 = new LinkedList<>();
        q3.add(1);
        int val = 0;

        for (int i=0; i<k; i++) {

            int v3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int v5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            int v7 = q7.isEmpty() ? Integer.MAX_VALUE : q7.peek();

            val = Math.min(v3, Math.min(v5, v7));

            if (val == v3) {
                q3.remove();
                q3.add(val * 3);
                q5.add(val * 5);
            }
            else if (val == v5) {
                q5.remove();
                q5.add(val * 5);
            }
            else {
                q7.remove();
            }

            q7.add(val * 7);
        }

        return val;
    }



    // Priority Queue ******************************************************************************
    public int kthMultiplePriorityQueue(int k) {
        if (k <= 0) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);

        int[] factors = new int[] {3, 5, 7};

        for (int i=0; i<k - 1; i++) {
            int peek = queue.poll();

            for (int factor : factors) {
                int value = peek * factor;
                if (value > 0 && !queue.contains(value)) {
                    queue.add(value);
                }
            }
        }

        return queue.peek();
    }


    // Naive ***************************************************************************************
    public int kthMultipleNaive(int k) {

        int value = -1;
        int count = 0;

        while (count < k) {

            value += 2;

            if (isValid(value)) {
                count += 1;
            }
        }

        return value;
    }

    // O log(n)
    private boolean isValid(int n) {
        if (n == 1) {
            return true;
        }
        else if (n % 3 == 0) {
            return isValid(n / 3);
        }
        else if (n % 5 == 0) {
            return isValid(n / 5);
        }
        else if (n % 7 == 0) {
            return isValid(n / 7);
        }

        return false;
    }


    /*
       Solution 2.
       Mi salvo la lista dei numeri precedenti.
       Per ogni numero precedente > di n / 7,
        lo moltiplico per 3, 5 o 7 e tengo traccia del minimo che sia maggiore dell'ultimo elemento in lista.

     */
}
