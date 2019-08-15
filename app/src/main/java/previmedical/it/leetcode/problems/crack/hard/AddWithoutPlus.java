package previmedical.it.leetcode.problems.crack.hard;

public class AddWithoutPlus {

    /*
        Write a function that adds two numbers. You should not use + or any arithmetic operators.
     */

    public int addWithoutPlus(int a, int b) {
        int and = a & b;
        int andShifted = and << 1;
        int xor = a ^ b;
        return xor | andShifted;
    }
}
