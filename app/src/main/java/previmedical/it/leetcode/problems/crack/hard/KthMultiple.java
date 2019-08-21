package previmedical.it.leetcode.problems.crack.hard;

import java.util.HashSet;
import java.util.Set;

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



    public int kthMultiple(int k) {

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
