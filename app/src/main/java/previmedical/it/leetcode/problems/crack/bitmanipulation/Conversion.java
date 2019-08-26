package previmedical.it.leetcode.problems.crack.bitmanipulation;

public class Conversion {

    /*
        Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
        EXAMPLE
        Input: 29 (or: 11101), 15 (or: 01111) Output: 2
     */

    public int conversion(int a, int b) {

        if (a == b) {
            return 0;
        }

        int count = 0;

        while (a != 0 || b != 0) {

            if ((a & 1) != (b & 1)) {
                count += 1;
            }

            a >>>= 1;
            b >>>= 1;
        }

        return count;
    }
}
