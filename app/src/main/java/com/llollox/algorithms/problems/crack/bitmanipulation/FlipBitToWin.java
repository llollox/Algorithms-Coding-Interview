package com.llollox.algorithms.problems.crack.bitmanipulation;

import java.util.ArrayList;

public class FlipBitToWin {

    /*
        You have an integer and you can flip exactly one bit from a O to a 1.
        Write code to find the length of the longest sequence of 1 s you could create.

        EXAMPLE
        Input: 1775 (or: 11011101111) Output: 8

        Solution 1.
        Convert the number into a list of integers.
        Calculate the maximum length of ones from the list.
     */


    public int flipToWinBruteForce(int n) {

        if (n == -1) {
            return Integer.BYTES * 8;
        }
        ArrayList<Integer> sequences = this.getAlternatingSequences(n);
        return this.findLongestSequence(sequences);
    }

    /*
        Return a list of the sizes of the sequences.
        The sequence starts off with the number of 0s (which might be 0)
        and then alternates with the counts of each value.

        Poichè mi da le lunghezze di ogni sequenza, otterrò come output
        sequenze di 1s e 0s alternate.

        Time O(b), Space O(b)
     */
    private ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i< Integer.BYTES * 8; i++) {

            if ( (n & 1) != searchingFor ) {
                sequences.add(counter);
                searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
                counter = 0;
            }

            counter++;
            n >>>= 1;
        }

        return sequences;
    }

    /*
        Given the lengths of alternating sequences of 0s and 1s,
        find the longest one we can build.

        Time O(b), Space O(1)
     */
    private int findLongestSequence(ArrayList<Integer> seq) {

        int maxSeq = 1;
        for (int i=0; i< seq.size(); i+= 2) {

            int zerosSeq = seq.get(i);
            int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;

            switch (zerosSeq) {
                case 0: thisSeq = Math.max(onesSeqLeft, onesSeqRight); break;
                case 1: thisSeq = onesSeqLeft + 1 + onesSeqRight; break;
                default: thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight); break;
            }

            maxSeq = Math.max(thisSeq, maxSeq);
        }

        return maxSeq;
    }



    /*
        Solution 2.
        To reduce the space usage, note that we don't need to hang on to the length of each sequence the entire time.
        We only need it long enough to compare each 1 s sequence to the immediately preceding 1 s sequence.
        Therefore, we can just walk through the integer doing this:
            - tracking the current 1s sequence length and the previous 1s sequence length.
            - when we see a zero, update previous Length:
                - If the next bit is a 1, previous Length should be set to current Length.
                - If the next bit is a 0, then we can't merge these sequences together. So, set previous Length to 0.

        Time: O(b), Space O(1)
     */
    public int flipBitToWin(int n) {

        // If all 1s returns immediately.
        if (~n == 0) {
            return Integer.BYTES * 8;  // Bytes = 4, * Bits per byte. Totale 32 bits maximum
        }

        int currentLength = 0;
        int previousLength = 0;

        int maxLength = 1;

        while (n != 0) {
            if ((n & 1) == 1) { // Current bit is 1
                currentLength++;
            }
            else if ((n & 1) == 0) { // Current bit is 0
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }

            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            n >>>= 1;
        }

        return maxLength;
    }
}
