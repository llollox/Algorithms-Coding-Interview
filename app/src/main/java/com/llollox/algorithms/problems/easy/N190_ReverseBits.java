package com.llollox.algorithms.problems.easy;

public class N190_ReverseBits {

    // you need treat n as an unsigned value
    // T O(1) S O(1)
    public int reverseBits(int n) {
        int reversed = 0;

        for (int i=0; i<32; i++) {
            reversed<<=1;
            if ((n & 1) == 1) {
                reversed |= 1;
            }

            n>>=1;
        }

        return reversed;
    }

    // you need treat n as an unsigned value
    // T O(1) S O(1)
    public int reverseBitsOptimal(int n) {
        n = (n & 0x0000ffff) << 16 | (n & 0xffff0000) >>> 16; // reverse two half
        n = (n & 0x00ff00ff) << 8  | (n & 0xff00ff00) >>> 8; // reverse 8 bits
        n = (n & 0x0f0f0f0f) << 4  | (n & 0xf0f0f0f0) >>> 4; // reverse 4 bits
        n = (n & 0x33333333) << 2  | (n & 0xcccccccc) >>> 2; // reverse 2 bits
        n = (n & 0x55555555) << 1  | (n & 0xaaaaaaaa) >>> 1;
        return n;
    }
}
