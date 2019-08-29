package previmedical.it.leetcode.problems.crack.hard;

public class MissingTwo {

    /*
        You are given an array with all the numbers from 1 to N appearing exactly once,
        except for one number that is missing.
        How can you find the missing number in O(N) time and 0(1) space?
        What if there were two numbers missing?
     */

    /*
        Questions?
        - Does it fit in memory? Yes
        - Does the array sorted? No
        - Can it contains duplicates? No

        Solution 1. Time O(n) Space O(1)
        - Li sommo tutti.
        - V = (N * (N + 1) / 2) - SUM
        - V è il numero mancante e lo ritorno.


        What if there were two numbers missing?
        - V = (N * (N + 1) / 2) - SUM
        - If a, b are the two missing numbers, therefore a + b = V.
        - a = V - b, b = V - a, pertanto se trovo a o b ho trovato anche l'altro.


        APPROACH 1: Time O(n log n) Space O(1)
        - Sort all numbers
        - Scan dei numeri, una volta trovato il primo mancante, ho trovato anche il secondo per differenza

        APPROACH 2: O(n) Space O(n)
        - Insert all numbers in a set from 1 to N
        - Scan dei numeri, per ogni numero trovato, lo rimuovo dal set
        - Gli ultimi due numeri che restano nel set sono i mancanti

        APPROACH 3: O(n) Space O(n/2)
        A = [1, 4, 5, 6]
        V = 5
        SUM = 21

        min = 1, always one
        max = 4, V - 1

        - Posso inserire in un set tutti i numeri da 1 a V / 2 (lower bound)
        - Scorro tutti i numeri di A e per ogni numero che incontro lo rimuovo dal set
        - k = il numero restante nel set
        - ritorno (k, V - k)

        APPROACH 4: O(n) Space O(1)
        A = [1, 4, 5, 6]
        V = 5
        SUM = 21
        a = V - b
        b = V - a
        a < b

        min = 1, always one
        max = 4, V - 1

        A = [2, 8, 4, 1, 9, 6, 5]
        PROD (9!) = 362880
        SUM = 45

        ACTUAL_PROD = 17280
        ACTUAL_SUM = 35

        S = 10
        P = PROD / ACTUAL_PROD = 21

        a + b = 10, b = 10 - a
        a * b = 21
        a * (10 - a) = 21
        -a^2 - 10a - 21 = 0
        Risolvendo l'equazione ottengo due soluzioni a = 3, a = 7
     */


    public int[] missingTwo(int[] array) {
        if (array == null) {
            return null;
        }

        int n = array.length + 2;
        int arraySum = this.sum(array);
        int arrayProd = this.prod(array);

        int sum = (n * (n + 1) / 2) - arraySum;
        int prod = factorial(n) / arrayProd;

        return this.solveFormula(-1, sum, -prod);
    }


    /*
        (-b +- sqrt(b^2 -4ac)) / 2a
     */
    private int[] solveFormula(int a, int b, int c) {
        int delta = (int) Math.sqrt((b*b) - (4 * a * c));
        int x1 = (-b - delta) / (2 * a);
        int x2 = (-b + delta) / (2 * a);
        return new int[] {x1, x2};
    }

    private int factorial(int n) {
        int prod = 1;
        while (n > 0) {
            prod *= n;
            n -= 1;
        }
        return prod;
    }

    private int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    private int prod(int[] array) {
        int prod = 1;
        for (int i : array) {
            prod *= i;
        }
        return prod;
    }

}
