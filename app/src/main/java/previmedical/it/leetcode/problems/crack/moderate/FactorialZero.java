package previmedical.it.leetcode.problems.crack.moderate;

public class FactorialZero {


    /*
         Write an algorithm which computes the number of trailing zeros in n factorial.

        Solution 1.
        Calculate the number of 5

        5! = 5 * 4 * 3 * 2 * 1 = 5 * 2 * 2 * 3 * 2 * 1

        - How to divide each number in factors
        - Count the number of 5

        - Divide each number by five and count the occurrences

        Space: O(1)
        Time: O(n * log5(n))

     */



    public int trailingZero(int n) {

        int numZeros = 0;

        if (n <= 0) {
            return 0;
        }

        for (int i=n; i>=1; i--) {
            numZeros += numOccurrencesOf5(i);
        }

        return numZeros;
    }


    int numOccurrencesOf5(int n) {
        int count = 0;
        while (n % 5 == 0) {
            count++;
            n = n / 5;
        }
        return count;
    }

}
