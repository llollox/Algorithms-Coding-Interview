package previmedical.it.leetcode.problems.crack.bitmanipulation;

public class Insertion {

    /*
        You are given two 32-bit numbers, N and M, and two bit positions, i and j.
        Write a method to insert M into N such that M starts at bit j and ends at bit i.
        You can assume that the bits j through i have enough space to fit all of M.
        That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
        You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
     */

    public int insertion(int n, int m, int i, int j) {

        int allOnes = ~0;  // 11111111
        int left = allOnes << j + 1; //11100000
        int right = (1 << i) - 1; // 00000011
        int maskN = left | right; // 11100011

        int nCleared = n & maskN;

        // Move m by i bits
        m <<= i;

        return nCleared | m;
    }
}
