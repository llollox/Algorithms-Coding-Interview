package com.llollox.algorithms.problems.crack.bitmanipulation;

public class PairWiseSwap {

    /*
        Write a program to swap odd and even bits in an integer with as few instructions
        as possible (e.g., bit O and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
     */

    // 0xAA == 10101010
    // 0x55 == 01010101

    // 1101011
    // 0010111
    public int pairWiseSwap(int n) {
       return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
    }
}
